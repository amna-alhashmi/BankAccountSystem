package com.example.BankAccountSystem.Service;

import com.example.BankAccountSystem.Models.Account;
import com.example.BankAccountSystem.Models.Customer;
import com.example.BankAccountSystem.Repositoris.AccountInterface;
import com.example.BankAccountSystem.Repositoris.CustomerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class CustomerService {
        @Autowired
        CustomerInterface customerInterface;
        public void addPersonalInformation(){
            Customer customer=new Customer();
            customer.setCustomerName("AHD");
            customer.setEmail("amna123.alhashmi@gmail.com");
            customer.setGender("Female");
            customer.setPhoneNumber(97223102);
            customer.setActive(true);
            customerInterface.save(customer);
        }
}
