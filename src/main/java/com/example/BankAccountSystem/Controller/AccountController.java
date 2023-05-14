package com.example.BankAccountSystem.Controller;

import com.example.BankAccountSystem.Models.Account;
import com.example.BankAccountSystem.Models.Customer;
import com.example.BankAccountSystem.Models.Transaction;
import com.example.BankAccountSystem.RequestObject.AccountRequest;
import com.example.BankAccountSystem.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "Account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "AccountForCustomer", method = RequestMethod.POST)
    public String addAccountForCustomer(@RequestBody AccountRequest accountRequest) {
        accountService.addAccountForCustomer(accountRequest);
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

    @RequestMapping(value = "getCustomerAccountInformationByCustomerId", method = RequestMethod.GET)
    public List<Account> getCustomerAccountInformationByCustomerId(@RequestParam Integer CustomerId) throws ParseException {
        List<Account> Account = accountService.getCustomerAccountInformationByCustomerId(CustomerId);
//        slackClient.sendMessage(studentService.formatStudentListForSlack(student).toString());
        return Account;
    }
    @RequestMapping(value = "makeMonthlyStatement", method = RequestMethod.GET)
    public ResponseEntity<String> makeMonthlyStatement(@RequestParam Integer accountId) {
        String statement = accountService.makeMonthlyStatement(accountId);
        return ResponseEntity.ok(statement);
    }
    @RequestMapping(value = "getAccountHistoryIncludingAllTransaction", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getAccountHistoryIncludingAllTransaction(@RequestParam Integer id) {
        List<Transaction> transactionList = accountService.getAccountHistoryIncludingAllTransaction(id);
        return ResponseEntity.ok(transactionList);
    }
}
