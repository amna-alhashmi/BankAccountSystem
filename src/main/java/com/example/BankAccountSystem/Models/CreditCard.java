package com.example.BankAccountSystem.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
public class CreditCard extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String customerName;
    Integer accountNumber;
    @ManyToOne
    @JoinColumn(name = "Customer_id",referencedColumnName = "id")
    Customer customer;

}
