package kz.tenko.BankCard.ManagementSystem.service;

import kz.tenko.BankCard.ManagementSystem.DAO.CardDAO;
import kz.tenko.BankCard.ManagementSystem.DAO.UserDAO;
import kz.tenko.BankCard.ManagementSystem.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDAO cardDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void saveCard(Card card) {
        card.setNumber(card.getNumber().replaceAll("\\D", ""));
        if (card.getNumber().matches("[0-9]{16}")) {
            cardDAO.saveCard(card);
        }
    }

    @Override
    @Transactional
    public List<Card> findCards() {
        boolean isAdmin = false;
        for (GrantedAuthority ga : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
            if (ga.getAuthority().endsWith("ADMIN")) {
                isAdmin = true;
            }
        }
        if (isAdmin) {
            return cardDAO.findCards();
        }

        var user = userDAO.findUserByEmail(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());

        return cardDAO.findCards(user.getId());
    }

    @Override
    @Transactional
    public void deleteCard(long id) {
        cardDAO.deleteCard(id);
    }

    @Override
    @Transactional
    public void cardBlockingRequest(String cardNumber) {
        cardDAO.blockingCard(cardNumber);
    }

    @Override
    @Transactional
    public void transferAmount(String cardFrom, String cardTo, long transferAmount) {
        long from = cardDAO.findBalance(cardFrom);
        if ((from - transferAmount) < 0) {
            throw new RuntimeException("Недостаточно средств");
        }
        cardDAO.changeBalance(cardFrom, -transferAmount);
        cardDAO.changeBalance(cardTo, transferAmount);
    }


}
