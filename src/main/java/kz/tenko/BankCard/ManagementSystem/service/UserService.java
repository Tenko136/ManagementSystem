package kz.tenko.BankCard.ManagementSystem.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface UserService {

    public void cardBlockRequest();

    public String moneyTransfer();

    public List<String> getCards();

    public Map<String, Integer> getBalance();
}

