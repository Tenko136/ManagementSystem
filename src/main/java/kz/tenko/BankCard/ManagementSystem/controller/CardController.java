package kz.tenko.BankCard.ManagementSystem.controller;

import kz.tenko.BankCard.ManagementSystem.DTO.FindCardsRequestDTO;
import kz.tenko.BankCard.ManagementSystem.entity.Card;
import kz.tenko.BankCard.ManagementSystem.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public List<Card> findAllCards(@RequestBody FindCardsRequestDTO findCardsRequestDTO) {
        return cardService.findCards(findCardsRequestDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/save-card")
    public void saveCard(@RequestBody Card card) {
        cardService.saveCard(card);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete-card/{id}")
    public void deleteCard(@PathVariable long id) {
        cardService.deleteCard(id);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/card-blocking-request")
    public void cardBlockingRequest(String cardNumber) {

        cardService.cardBlockingRequest(cardNumber);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/transfer")
    public ResponseEntity<?> transferAmount(String cardFrom, String cardTo, long transferAmount) {
        try {
            cardService.transferAmount(cardFrom, cardTo, transferAmount);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
