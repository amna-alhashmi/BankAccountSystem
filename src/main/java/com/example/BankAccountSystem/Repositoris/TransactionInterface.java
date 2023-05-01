package com.example.BankAccountSystem.Repositoris;

import com.example.BankAccountSystem.Models.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionInterface extends CrudRepository<Transaction,Integer> {
}
