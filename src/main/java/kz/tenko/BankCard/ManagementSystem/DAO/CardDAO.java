package kz.tenko.BankCard.ManagementSystem.DAO;

import kz.tenko.BankCard.ManagementSystem.entity.Card;

import java.util.List;

public interface CardDAO {

    void saveCard(Card card);

    List<Card> findCards();

    List<Card> findCards(Long userId);

    void deleteCard(long id);

    void blockingCard(String cardNumber);

    Long findBalance(String number);

    void changeBalance(String number, Long amount);
}
