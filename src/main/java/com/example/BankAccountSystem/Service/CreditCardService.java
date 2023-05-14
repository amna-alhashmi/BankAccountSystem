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
        public void addCreditCardForCustomer(){
            CreditCard creditCard=new CreditCard();

            creditCard.setCustomerName("Salama");
            creditCard.setAccountNumber(1527350123);

            creditCard.setCustomer(customerInterface.getCustomerName("Amna"));
            creditCardInterface.save(creditCard);
        }
        public Boolean getStatusOfCreditCardApplication(Integer creditCardId){
            return creditCardInterface.getStatusOfCreditCardApplication(creditCardId);
        }
}
