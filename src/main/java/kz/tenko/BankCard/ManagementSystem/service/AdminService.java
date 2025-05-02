package kz.tenko.BankCard.ManagementSystem.service;

import java.util.List;

public interface AdminService {

    //todo
    public void cardManagement(); // стоит разделить

    public List<String> getUsers();

    public List<String> getCards();
}
