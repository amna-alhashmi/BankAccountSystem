package com.example.BankAccountSystem.Controller;

import com.example.BankAccountSystem.Models.Account;
import com.example.BankAccountSystem.Models.Customer;
import com.example.BankAccountSystem.Models.Transaction;
import com.example.BankAccountSystem.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "Account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @RequestMapping(value = "AccountForCustomer", method = RequestMethod.POST)
    public String addAccountForCustomer() {
        accountService.addAccountForCustomer();
        return "Account add successful";
    }

    @RequestMapping(value = "getAccountBalanceForSpecificAccount", method = RequestMethod.GET)
    public Double getAccountBalanceForSpecificAccount(@RequestParam Long accountNumber) {
        return accountService.getAccountBalanceForSpecificAccount(accountNumber);
        //slackClient.sendMessage(studentService.formatStudentObjectForSlack(student).toString());

    }
        @RequestMapping(value = "AllCustomerAccount", method = RequestMethod.POST)
        public List<Account> getAllCustomerAccount(@RequestParam Long accountNumber) throws ParseException {
            List<Account> account = accountService.getAllCustomerAccount(accountNumber);
            return account;
        }
}
