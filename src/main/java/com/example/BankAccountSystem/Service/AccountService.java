package com.example.BankAccountSystem.Service;

import com.example.BankAccountSystem.Models.Account;
import com.example.BankAccountSystem.Models.Customer;
import com.example.BankAccountSystem.Models.Transaction;
import com.example.BankAccountSystem.Repositoris.AccountInterface;
import com.example.BankAccountSystem.Repositoris.CustomerInterface;
import com.example.BankAccountSystem.Repositoris.TransactionInterface;
import com.example.BankAccountSystem.RequestObject.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountInterface accountInterface;
    @Autowired
    CustomerInterface customerInterface;
    @Autowired
    TransactionInterface transactionInterface;
    public void addAccountForCustomer(AccountRequest request){

        Account account=new Account();
        account.setAccountNumber(request.getAccountNumber());
        account.setIsActive(request.getIsActive());

        Integer id = customerInterface.getCustomerId(request.getCustomerName());
        Customer customerId = customerInterface.geId(id);
        account.setCustomer(customerId);
        accountInterface.save(account);
    }
    public List<Account> getAllCustomerAccount(Long account_number){
        return accountInterface.getAllCustomerAccount(account_number);
    }
    public Double getAccountBalanceForSpecificAccount(Long accountNumber){
        return accountInterface.getAccountBalanceForSpecificAccount(accountNumber);


    }
    public List<Account> getCustomerAccountInformationByCustomerId(Integer id)throws ParseException {
        List<Account> account=accountInterface.getCustomerAccountInformationByCustomerId(id);
        return account;

    }
    public String makeMonthlyStatement(Integer accountId) {
        Account account = accountInterface.findById(accountId).get();
        Customer customer = account.getCustomer();
        LocalDate localDate = LocalDate.now();
        LocalDate statementDate = LocalDate.of(localDate.getYear(), localDate.getMonth(), 1);

        String statementOfAccount = "Monthly Statement Of Account :" + account.getAccountNumber() +
                "\n Customer Name :" + customer.getCustomerName() +
                "\n Customer Email :" + customer.getEmail() +
                "\n Customer Phone :" + customer.getPhoneNumber()+
                "\n Date" + "\t" + localDate.getYear() + "\t" + localDate.getMonth() + "\t" + localDate.getDayOfMonth() +
                "\n Account Balance :" + account.getBalance();

        return statementOfAccount;
    }
    public List<Transaction> getAccountHistoryIncludingAllTransaction(Integer id) {
        Account account = accountInterface.findById(id).get();
        List<Transaction> transactionList = transactionInterface.findByAccount(account);
        return transactionList;
    }
}
