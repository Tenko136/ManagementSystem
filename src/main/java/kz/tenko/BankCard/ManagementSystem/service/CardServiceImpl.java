package kz.tenko.BankCard.ManagementSystem.service;

import kz.tenko.BankCard.ManagementSystem.DAO.CardDAO;
import kz.tenko.BankCard.ManagementSystem.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDAO cardDAO;

    @Override
    @Transactional
    public void saveCard(Card card) {
        cardDAO.saveCard(card);
    }

    @Override
    @Transactional
    public List<Card> findCards() {
        return cardDAO.findCards();
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

    //todo вывод в контроллере http ответ
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
