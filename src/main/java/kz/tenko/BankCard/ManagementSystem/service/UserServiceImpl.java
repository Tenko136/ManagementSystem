package kz.tenko.BankCard.ManagementSystem.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void cardBlockRequest() {

    }

    @Override
    public String moneyTransfer() {
        return "";
    }

    @Override
    public List<String> getCards() {
        return List.of();
    }

    @Override
    public Map<String, Integer> getBalance() {

        return null;
    }
}
