package com.example.BankAccountSystem.Service;

import com.example.BankAccountSystem.Models.Account;
import com.example.BankAccountSystem.Models.CreditCard;
import com.example.BankAccountSystem.Repositoris.AccountInterface;
import com.example.BankAccountSystem.Repositoris.CreditCardInterface;
import com.example.BankAccountSystem.Repositoris.CustomerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class CreditCardService {
        @Autowired
        CreditCardInterface creditCardInterface;
        @Autowired
        CustomerInterface customerInterface;
        public void addCreditCardForCustomer(CreditCard creditCard){
            CreditCard creditCard1=new CreditCard();

            creditCard1.setCustomerName(creditCard.getCustomerName());
            creditCard1.setAccountNumber(creditCard.getAccountNumber());

            creditCard1.setCustomer(customerInterface.getCustomerName(creditCard.getCustomerName()));
            creditCardInterface.save(creditCard1);
        }
        public Boolean getStatusOfCreditCardApplication(Integer creditCardId){
            return creditCardInterface.getStatusOfCreditCardApplication(creditCardId);
        }
}
