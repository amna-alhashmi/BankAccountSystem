package com.example.BankAccountSystem.Service;

import com.example.BankAccountSystem.Models.Account;
import com.example.BankAccountSystem.Models.Customer;
import com.example.BankAccountSystem.Models.Transaction;
import com.example.BankAccountSystem.Repositoris.AccountInterface;
import com.example.BankAccountSystem.Repositoris.CustomerInterface;
import com.example.BankAccountSystem.Repositoris.TransactionInterface;
import com.example.BankAccountSystem.RequestObject.TransactionRequest;
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
        public void addTransactionForASpecificAccount(TransactionRequest transactionRequest){
            Transaction transactionInformation=new Transaction();
            transactionInformation.setAmount(transactionRequest.getAmount());
            transactionInformation.setIsActive(transactionRequest.getIsActive());
            transactionInformation.setFees(transactionRequest.getFees());
            Integer id = accountInterface.getAccountId(transactionRequest.getAccountNumber());
            Account accountId = accountInterface.findById(id).get();
            transactionInformation.setAccount(accountId);
            Double transactionAmount= transactionRequest.getAmount();
            Double accountBalance=accountId.getBalance();
            Double newBalance=accountBalance-transactionAmount;
            accountId.setBalance(newBalance);
            accountInterface.save(accountId);
            transactionInterface.save(transactionInformation);
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
