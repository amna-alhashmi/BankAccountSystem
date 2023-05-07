package com.example.BankAccountSystem.Controller;

import com.example.BankAccountSystem.Models.Transaction;
import com.example.BankAccountSystem.Service.CustomerService;
import com.example.BankAccountSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

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
        @RequestMapping(value = "geDetailsOfSpecificTransaction", method = RequestMethod.GET)
        public Transaction getTransactionById(@RequestParam Integer transactionId) {
            Transaction transaction = transactionService.getTransactionById(transactionId);
            //slackClient.sendMessage(studentService.formatStudentObjectForSlack(student).toString());
            return transaction;
        }
    @RequestMapping(value = "getAllTransactionForSpecificAccount", method = RequestMethod.GET)
    public List<Transaction> getTransactionByAccountId(@RequestParam Integer accountId) throws ParseException {
        List<Transaction> transactions=transactionService.getTransactionByAccountId(accountId);
//        slackClient.sendMessage(studentService.formatStudentListForSlack(student).toString());
        return transactions;

    }
}
