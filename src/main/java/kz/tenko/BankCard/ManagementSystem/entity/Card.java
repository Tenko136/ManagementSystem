package kz.tenko.BankCard.ManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.Type;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "number")
    private String number;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "status")
    @JdbcType(LongVarcharJdbcType.class)
    private CardStatus status;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "card_blocking_request")
    boolean cardBlockingRequest;

    public Card() {
    }

    public Card(Long userId, String number, LocalDate expirationDate, CardStatus status, Long balance) {
        this.userId = userId;
        this.number = number;
        this.expirationDate = expirationDate;
        this.status = status;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
