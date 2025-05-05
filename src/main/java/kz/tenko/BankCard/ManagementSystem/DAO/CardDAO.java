package kz.tenko.BankCard.ManagementSystem.DAO;

import kz.tenko.BankCard.ManagementSystem.entity.Card;

import java.util.List;

public interface CardDAO {

    void saveCard(Card card);
    List<Card> findCards();
    void deleteCard(long id);
    void blockingCard(boolean cardBlocking);
}
