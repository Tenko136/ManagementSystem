package kz.tenko.BankCard.ManagementSystem.controller;

import kz.tenko.BankCard.ManagementSystem.entity.User;
import kz.tenko.BankCard.ManagementSystem.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/find-users")
    public List<User> findUsers() {
        return userService.findUsers();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save-user")
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete-user/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

}
