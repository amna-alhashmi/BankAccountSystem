package com.example.BankAccountSystem.Controller;

import com.example.BankAccountSystem.Models.Loan;
import com.example.BankAccountSystem.Models.Transaction;
import com.example.BankAccountSystem.Service.LoanService;
import com.example.BankAccountSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
    @RequestMapping(value = "Loan")
    public class LoanController {
        @Autowired
        LoanService loanService;
        @RequestMapping(value = "LoanApplicationForCustomer", method = RequestMethod.POST)
        public String addLoanApplicationForCustomer(Loan loan) {
            loanService.addLoanApplicationForCustomer(loan);

            return "Loan add successful";
        }
    @RequestMapping(value = "getStatusOfLoanApplication",method = RequestMethod.GET)
    public Boolean getStatusOfLoanApplication(@RequestParam Integer loanId){
       return loanService.getStatusOfLoanApplication(loanId);
//        slackClient.sendMessage(studentService.formatStudentListForSlack(activeStudentsList).toString());
    }
}
