package kz.tenko.BankCard.ManagementSystem.service;

import kz.tenko.BankCard.ManagementSystem.entity.Card;

import java.util.List;

public interface CardService {
void saveCard(Card card);
List<Card> findCards();
void deleteCard(long id);
void cardBlockingRequest(boolean cardBlocking);
}
