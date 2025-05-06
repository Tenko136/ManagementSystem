package kz.tenko.BankCard.ManagementSystem.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import kz.tenko.BankCard.ManagementSystem.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardDAOImpl implements CardDAO {

    @Autowired
    private final EntityManager entityManager;

    public CardDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveCard(Card card) {
        Card c = entityManager.merge(card);
        card.setId(c.getId());
    }

    @Override
    public List<Card> findCards() {

        Query query = entityManager
                .createQuery("from Card");

        return query.getResultList();
    }

    @Override
    public void deleteCard(long id) {
        Query query = entityManager.createQuery("from Card where id =:cardId");
        query.setParameter("cardId", id);
        query.executeUpdate();
    }

    @Override
    public void blockingCard(String cardNumber) {
        Query query = entityManager.createQuery("update Card set cardBlockingRequest = true where number =:cardNumber");
        query.setParameter("cardNumber", cardNumber);
        query.executeUpdate();
    }

    @Override
    public Long findBalance(String number) {
        Card card = entityManager.find(Card.class, number);
        return card.getBalance();
    }

    @Override
    public void changeBalance(String number, Long amount) {
        Query query = entityManager.createQuery("update Card set balance = balance + :amount where number = :number");
        query.setParameter("amount", amount);
        query.setParameter("number", number);
        query.executeUpdate();
    }
}
