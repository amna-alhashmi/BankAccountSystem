package com.example.BankAccountSystem.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class TransactionRequest {
    Double amount;
    Long accountNumber;
    String isActive;
    Double fees;
}
