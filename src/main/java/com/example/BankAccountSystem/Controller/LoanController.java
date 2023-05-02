package com.example.BankAccountSystem.Controller;

import com.example.BankAccountSystem.Service.LoanService;
import com.example.BankAccountSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping(value = "Loan")
    public class LoanController {
        @Autowired
        LoanService loanService;
        @RequestMapping(value = "LoanApplicationForCustomer", method = RequestMethod.POST)
        public String addLoanApplicationForCustomer() {
            loanService.addLoanApplicationForCustomer();

            return "Loan add successful";
        }
}
