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
public class Customer extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull
    Integer id;
    @Column(name="customer_name")

    @NotNull
    @Size(max=3,min=50)
    String customerName;
    String email;
    String gender;
    Integer phoneNumber;


}
