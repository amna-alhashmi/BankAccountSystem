package com.example.BankAccountSystem.Service;

import com.example.BankAccountSystem.Models.Account;
import com.example.BankAccountSystem.Models.Customer;
import com.example.BankAccountSystem.Models.Transaction;
import com.example.BankAccountSystem.Repositoris.AccountInterface;
import com.example.BankAccountSystem.Repositoris.CustomerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountInterface accountInterface;
    @Autowired
    CustomerInterface customerInterface;
    public void addAccountForCustomer(){
        Account account=new Account();

        account.setAccountNumber(3245172901736173L);
        account.setActive(true);
        account.setBalance(11.32);
        Integer id = customerInterface.getCustomerId("AHD");
        Customer customerId = customerInterface.geId(id);
        account.setCustomer(customerId);
        accountInterface.save(account);
    }
    public List<Account> getAllCustomerAccount(Long account_number){
        return accountInterface.getAllCustomerAccount(account_number);
    }
    public Double getAccountBalanceForSpecificAccount(Long accountNumber){
        return accountInterface.getAccountBalanceForSpecificAccount(accountNumber);


    }
}
