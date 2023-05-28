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

        public void addLoanApplicationForCustomer(Loan loan){
            Loan loan1=new Loan();
            loan1.setAmount(loan.getAmount());
            loan1.setInterest(loan.getInterest());
            Integer id = customerInterface.getCustomerId("Amna");
            Customer customerId = customerInterface.geId(id);
            loan1.setCustomer(customerId);
            loanInterface.save(loan1);
        }
    public Boolean getStatusOfLoanApplication(Integer loanId){
    return loanInterface.getStatusOfLoanApplication(loanId);
    }
}
