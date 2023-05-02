package com.example.BankAccountSystem.Controller;

import com.example.BankAccountSystem.Service.CreditCardService;
import com.example.BankAccountSystem.Service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping(value = "CreditCard")
    public class CreditCardController {
//        @Autowired
//        CreditCardService creditCardService;
//        @RequestMapping(value = "CreditCardApplicationForCustomer", method = RequestMethod.POST)
//        public String addCreditCardApplicationForCustomer() {
//            creditCardService.addCreditCardApplicationForCustomer();
//
//            return "CreditCard add successful";
//        }
}
