package com.example.BankAccountSystem.Service;

import com.example.BankAccountSystem.Models.Account;
import com.example.BankAccountSystem.Models.Customer;
import com.example.BankAccountSystem.Repositoris.AccountInterface;
import com.example.BankAccountSystem.Repositoris.CustomerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountInterface accountInterface;
    @Autowired
    CustomerInterface customerInterface;
    public void addAccountForCustomer(){
        Account account=new Account();

        account.setAccountNumber(32415822297233L);
        account.setActive(true);
        account.setBalance(15.12);
        account.setCustomer(customerInterface.getCustomerName("AHD"));
        accountInterface.save(account);
    }
}
