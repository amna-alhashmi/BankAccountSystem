package com.example.BankAccountSystem.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter
@Setter
public class Loan extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull
    Integer id;
    @NotNull
    Double amount;
    @NotNull
    Double interest;
    @ManyToOne
    @JoinColumn(name = "Customer_id",referencedColumnName = "id")
    Customer customer;

}
