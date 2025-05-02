package kz.tenko.BankCard.ManagementSystem.DTO;

public class UserInfoDTO {

    String name;
    String cardNumber;

    public UserInfoDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
