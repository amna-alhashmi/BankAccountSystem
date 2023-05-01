package com.example.BankAccountSystem.Service;

import com.example.BankAccountSystem.Models.Customer;
import com.example.BankAccountSystem.Models.Transaction;
import com.example.BankAccountSystem.Repositoris.CustomerInterface;
import com.example.BankAccountSystem.Repositoris.TransactionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    @Service
    public class TransactionService {
        @Autowired
        TransactionInterface transactionInterface;
        public void addTransactionForASpecificAccount(){
            Transaction transaction=new Transaction();
            transaction.setFees(1222.1);
            transaction.setAmount(12.1);
            transaction.setActive(true);
            transaction.setId(1);
            transactionInterface.save(transaction);
        }
}
