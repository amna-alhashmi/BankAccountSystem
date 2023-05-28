package com.example.BankAccountSystem.Controller;

import com.example.BankAccountSystem.Models.Account;
import com.example.BankAccountSystem.Models.Customer;
import com.example.BankAccountSystem.Models.Loan;
import com.example.BankAccountSystem.Models.Transaction;
import com.example.BankAccountSystem.Service.AccountService;
import com.example.BankAccountSystem.Service.CustomerService;
import com.example.BankAccountSystem.Service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;


@RestController
    @RequestMapping(value = "Customer")
    public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    AccountService accountService;
    @Autowired
    LoanService loanService;

    @RequestMapping(value = "PersonalInformation", method = RequestMethod.POST)
    public String addPersonalInformation(@RequestBody @Valid Customer customer, BindingResult bindingResult) {
        customerService.addPersonalInformation(customer);

        return "Customer add successful";
    }

    @RequestMapping(value = "CustomerInformation", method = RequestMethod.POST)
    public Customer updateCustomerInformation(@RequestParam String email, Integer phoneNumber, Integer id) throws ParseException {
        Customer customer = customerService.updateCustomerInformation(email, phoneNumber, id);
        return customer;
    }
    @RequestMapping(value = "getCustomerAccountInformationByCustomerId", method = RequestMethod.GET)
    public List<Account> getCustomerAccountInformationByCustomerId(@RequestParam Integer CustomerId) throws ParseException {
        List<Account> account = accountService.getCustomerAccountInformationByCustomerId(CustomerId);
//        slackClient.sendMessage(studentService.formatStudentListForSlack(student).toString());
        return account;
    }
    @RequestMapping(value = "LoanApplicationForCustomer", method = RequestMethod.POST)
    public String addLoanApplicationForCustomer(Loan loan) {
        loanService.addLoanApplicationForCustomer(loan);

        return "Loan add successful";
    }
    @RequestMapping(value = "getViewStatusOfLoanApplication",method = RequestMethod.GET)
    public Boolean getViewStatusOfLoanApplication(@RequestParam Integer customerId){
        return customerService.getViewStatusOfLoanApplication(customerId);
//        slackClient.sendMessage(studentService.formatStudentListForSlack(activeStudentsList).toString());
    }
    @RequestMapping(value = "getCustomerTransactionHistoryAcrossAllTheirAccounts", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getCustomerTransactionHistoryAcrossAllTheirAccounts(@RequestParam Integer customerId) {
        List<Transaction> transactionList = customerService.getCustomerTransactionHistoryAcrossAllTheirAccounts(customerId);
        return ResponseEntity.ok(transactionList);
    }

    }


