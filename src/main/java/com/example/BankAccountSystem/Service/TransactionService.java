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
        @Autowired
        CustomerInterface customerInterface;
        public void addTransactionForASpecificAccount(){
            Transaction transaction=new Transaction();
            transaction.setFees(1222.1);
            transaction.setAmount(12.1);
            transaction.setActive(true);
            Integer id = customerInterface.getCustomerId("AHD");
            Customer customerId = customerInterface.geId(id);
            transaction.setCustomer(customerId);
            transactionInterface.save(transaction);
        }
}
