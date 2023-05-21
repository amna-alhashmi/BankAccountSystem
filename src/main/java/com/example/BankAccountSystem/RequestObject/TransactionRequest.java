package com.example.BankAccountSystem.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class TransactionRequest {
    Double amount;
    Long accountNumber;
    String isActive;
    Double fees;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }
}
