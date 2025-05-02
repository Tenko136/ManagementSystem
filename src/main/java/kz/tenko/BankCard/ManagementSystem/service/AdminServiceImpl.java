package kz.tenko.BankCard.ManagementSystem.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public void cardManagement() {

    }

    @Override
    public List<String> getUsers() {
        return List.of();
    }

    @Override
    public List<String> getCards() {
        return List.of();
    }
}
