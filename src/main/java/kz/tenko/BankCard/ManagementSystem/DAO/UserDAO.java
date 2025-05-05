package kz.tenko.BankCard.ManagementSystem.DAO;

import kz.tenko.BankCard.ManagementSystem.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> findUsers();

    void saveUser(User user);

    void deleteUser(long id);
}
