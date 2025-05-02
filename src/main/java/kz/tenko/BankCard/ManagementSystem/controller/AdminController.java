package kz.tenko.BankCard.ManagementSystem.controller;

import kz.tenko.BankCard.ManagementSystem.DTO.UserInfoDTO;
import kz.tenko.BankCard.ManagementSystem.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/all-cards")
    public  List<String> getAllCards() {
return null;
    }

    @GetMapping("/all-users")
    public List<UserInfoDTO> getAllUsers() {
        return null;
    }

}
