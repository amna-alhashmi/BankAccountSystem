package com.example.BankAccountSystem.Service;

import com.example.BankAccountSystem.Models.Account;
import com.example.BankAccountSystem.Models.Customer;
import com.example.BankAccountSystem.Models.Transaction;
import com.example.BankAccountSystem.Repositoris.AccountInterface;
import com.example.BankAccountSystem.Repositoris.CustomerInterface;
import com.example.BankAccountSystem.Repositoris.LoanInterface;
import com.example.BankAccountSystem.Repositoris.TransactionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
    public class CustomerService {
        @Autowired
        CustomerInterface customerInterface;
        @Autowired
        AccountInterface accountInterface;
        @Autowired
    LoanInterface loanInterface;
        @Autowired
    TransactionInterface transactionInterface;
        public void addPersonalInformation(Customer customer){
            Customer customerInformation=new Customer();
            customerInformation.setCustomerName(customer.getCustomerName());
            customerInformation.setEmail(customer.getEmail());
            customerInformation.setGender(customer.getGender());
            customerInformation.setPhoneNumber(customer.getPhoneNumber());
            customerInformation.setIsActive(customer.getIsActive());
            customerInterface.save(customer);
        }
    public Customer updateCustomerInformation(String email, Integer phoneNumber,Integer id) throws ParseException {

        Customer customer = customerInterface.getCustomerById(id);
        customer.setEmail("a.m.n.a123@gmail.com");
        customer.setPhoneNumber(97229082);
        customerInterface.save(customer);
        return customer;
    }
    public List<Account> getCustomerAccountInformationByCustomerId(Integer id)throws ParseException {
        List<Account> accounts=accountInterface.getCustomerAccountInformationByCustomerId(id);
        return accounts;

    }
    public Boolean getViewStatusOfLoanApplication(Integer customerId){
        return loanInterface.getViewStatusOfLoanApplication(customerId);
    }
    public List<Transaction> getCustomerTransactionHistoryAcrossAllTheirAccounts(Integer id) {
        Account account = accountInterface.findById(id).get();
        List<Transaction> transactionList = transactionInterface.findByAccount(account);
        return transactionList;
    }
}
