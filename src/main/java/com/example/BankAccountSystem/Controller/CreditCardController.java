package com.example.BankAccountSystem.Controller;

import com.example.BankAccountSystem.Models.CreditCard;
import com.example.BankAccountSystem.Service.CreditCardService;
import com.example.BankAccountSystem.Service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
    @RequestMapping(value = "CreditCard")
    public class CreditCardController {
        @Autowired
        CreditCardService creditCardService;
        @RequestMapping(value = "CreditCardApplicationForCustomer", method = RequestMethod.POST)
        public String addCreditCardForCustomer(@RequestBody @Valid CreditCard creditCard, BindingResult bindingResult) {
            creditCardService.addCreditCardForCustomer(creditCard);

            return "CreditCard add successful";
        }
        @RequestMapping(value = "getStatusOfCreditCardApplication",method = RequestMethod.GET)
        public Boolean getStatusOfCreditCardApplication(@RequestParam Integer creditCardId){
            return creditCardService.getStatusOfCreditCardApplication(creditCardId);
//        slackClient.sendMessage(studentService.formatStudentListForSlack(activeStudentsList).toString());
        }
}
