package com.example.BankAccountSystem.Controller;

import com.example.BankAccountSystem.Models.Customer;
import com.example.BankAccountSystem.Service.AccountService;
import com.example.BankAccountSystem.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


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

    @RequestMapping(value = "CustomerInformation", method = RequestMethod.POST)
    public Customer updateCustomerInformation(@RequestParam String email, Integer phoneNumber, Integer id) throws ParseException {
        Customer customer = customerService.updateCustomerInformation(email, phoneNumber, id);
        return customer;
    }
}

