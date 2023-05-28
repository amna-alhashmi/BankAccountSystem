package com.example.BankAccountSystem.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Setter
@Getter
public class CreditCard extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    Integer id;
    @NotNull
    @Size(min = 3,max = 50)
    String customerName;
    @NotNull
    Integer accountNumber;
    @ManyToOne
    @JoinColumn(name = "Customer_id",referencedColumnName = "id")
    Customer customer;

}
