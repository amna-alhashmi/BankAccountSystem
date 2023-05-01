package com.example.BankAccountSystem.Controller;

import com.example.BankAccountSystem.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
