package com.example.BankAccountSystem.Service;

import com.example.BankAccountSystem.Models.Account;
import com.example.BankAccountSystem.Models.Customer;
import com.example.BankAccountSystem.Models.Transaction;
import com.example.BankAccountSystem.Repositoris.AccountInterface;
import com.example.BankAccountSystem.Repositoris.CustomerInterface;
import com.example.BankAccountSystem.Repositoris.TransactionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
    public class TransactionService {
        @Autowired
        TransactionInterface transactionInterface;
        @Autowired
        AccountInterface accountInterface;
        public void addTransactionForASpecificAccount(){
            Transaction transaction=new Transaction();
            transaction.setFees(123.32);
            transaction.setAmount(10.32);
            transaction.setActive(true);
            Integer id = accountInterface.getAccountId(3245172901736173L);
            Account accountId = accountInterface.geId(id);
            transaction.setAccount(accountId);
            transactionInterface.save(transaction);
        }
        public Transaction getTransactionById(Integer transactionId){
            Transaction transaction=transactionInterface.getTransactionById(transactionId);
            return transaction;

        }
    public List<Transaction> getTransactionByAccountId(Integer id)throws ParseException {
            List<Transaction> transaction=transactionInterface.getTransactionByAccountId(id);
        return transaction;

    }
}
