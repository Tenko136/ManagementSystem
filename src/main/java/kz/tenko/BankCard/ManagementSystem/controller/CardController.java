package kz.tenko.BankCard.ManagementSystem.controller;

import kz.tenko.BankCard.ManagementSystem.entity.Card;
import kz.tenko.BankCard.ManagementSystem.service.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }


    @GetMapping("/find-cards")
    public List<Card> findAllCards() {   // для админов - все + баланс, для клиентов - только свои + баланс
        return cardService.findCards();
    }

    @PutMapping("/save-card")
    public void saveCard(Card card) {
        cardService.saveCard(card);
    }

    @DeleteMapping("/delete-card/{id}")
    public void deleteCard(@PathVariable long id) {
        cardService.deleteCard(id);
    }

    @PostMapping("/card-blocking-request")
    public void cardBlockingRequest(String cardNumber) {  // клиент - запрос
        cardService.cardBlockingRequest(cardNumber);
    }


    @PostMapping("/transfer")
    public void transferAmount(String cardFrom, String cardTo, long transferAmount) {
        cardService.transferAmount(cardFrom, cardTo, transferAmount);

    }
}
