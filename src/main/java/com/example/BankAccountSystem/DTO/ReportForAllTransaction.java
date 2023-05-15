package com.example.BankAccountSystem.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ReportForAllTransaction {
    Double amount;
    Long accountNumber;
    String isActive;
    Double fees;

    public ReportForAllTransaction(Double amount, Long accountNumber, String isActive, Double fees) {
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.isActive = isActive;
        this.fees = fees;
    }
}
