package com.example.BankAccountSystem.Controller;

import com.example.BankAccountSystem.Service.AccountService;
import com.example.BankAccountSystem.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping(value = "Customer")
    public class CustomerController {
        @Autowired
        CustomerService customerService;
        @RequestMapping(value = "PersonalInformation", method = RequestMethod.POST)
        public String addPersonalInformation() {
            customerService.addPersonalInformation();

            return "Customer add successful";
        }
}
