package com.example.BankAccountSystem.Service;

import com.example.BankAccountSystem.Models.Customer;
import com.example.BankAccountSystem.Models.Loan;
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
            loan.setAmount(255.12);
            loan.setInterest(34.1);
            Integer id = customerInterface.getCustomerId("Amna");
            Customer customerId = customerInterface.geId(id);
            loan.setCustomer(customerId);
            loanInterface.save(loan);
        }
    public Boolean getStatusOfLoanApplication(Integer loanId){
    return loanInterface.getStatusOfLoanApplication(loanId);
    }
}
