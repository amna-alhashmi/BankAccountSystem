package com.example.BankAccountSystem.Repositoris;

import com.example.BankAccountSystem.Models.Customer;
import com.example.BankAccountSystem.Models.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionInterface extends CrudRepository<Transaction,Integer> {
    @Query(value = "SELECT s FROM Transaction s WHERE s.id= :transactionId")
    Transaction getTransactionById(@Param("transactionId")Integer transactionId);
    @Query(value = "SELECT s From Transaction s WHERE s.account.id = :accountId")
    List<Transaction> getTransactionByAccountId(@Param("accountId") Integer accountId);
}
