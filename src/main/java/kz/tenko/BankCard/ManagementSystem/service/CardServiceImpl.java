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
    public void cardBlockingRequest(boolean cardBlocking) {
        cardDAO.blockingCard(cardBlocking);
    }


}
