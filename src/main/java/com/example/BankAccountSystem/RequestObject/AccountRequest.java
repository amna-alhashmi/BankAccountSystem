package com.example.BankAccountSystem.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class AccountRequest {
    Double balance;
    Long accountNumber;
    String customerName;
    String isActive;

}
