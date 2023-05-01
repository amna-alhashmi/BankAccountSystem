package com.example.BankAccountSystem.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "BankTransction")
public class Transaction extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Double fees;
    Double amount;
    @ManyToOne
    @JoinColumn(name = "Account_id",referencedColumnName = "id")
    Account account;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
