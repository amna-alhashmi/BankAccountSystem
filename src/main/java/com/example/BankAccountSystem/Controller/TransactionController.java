package com.example.BankAccountSystem.Controller;

import com.example.BankAccountSystem.Service.CustomerService;
import com.example.BankAccountSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping(value = "Transaction")
    public class TransactionController {
        @Autowired
        TransactionService transactionService;
        @RequestMapping(value = "TransactionForSpecificAccount", method = RequestMethod.POST)
        public String addTransactionForASpecificAccount() {
            transactionService.addTransactionForASpecificAccount();

            return "Transaction add successful";
        }
}
