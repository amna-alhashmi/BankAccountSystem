package com.example.BankAccountSystem.Service;

import com.example.BankAccountSystem.Models.Account;
import com.example.BankAccountSystem.Models.Loan;
import com.example.BankAccountSystem.Repositoris.AccountInterface;
import com.example.BankAccountSystem.Repositoris.CustomerInterface;
import com.example.BankAccountSystem.Repositoris.LoanInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    @Service
    public class LoanService {
        @Autowired
        LoanInterface loanInterface;
        @Autowired
        CustomerInterface customerInterface;
        public void addLoanApplicationForCustomer(){
            Loan loan=new Loan();

            loan.setAmount(123.21);
            loan.setInterest(22.3);
            loan.setCustomer(customerInterface.getCustomerName("AHD"));
            loanInterface.save(loan);
        }
}
