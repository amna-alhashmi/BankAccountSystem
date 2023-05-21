package com.example.BankAccountSystem.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Setter
@Getter
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
   
}
