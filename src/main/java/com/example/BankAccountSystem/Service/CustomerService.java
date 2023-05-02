package com.example.BankAccountSystem.Service;

import com.example.BankAccountSystem.Models.Account;
import com.example.BankAccountSystem.Models.Customer;
import com.example.BankAccountSystem.Repositoris.AccountInterface;
import com.example.BankAccountSystem.Repositoris.CustomerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
    public class CustomerService {
        @Autowired
        CustomerInterface customerInterface;
        public void addPersonalInformation(){
            Customer customer=new Customer();
            customer.setCustomerName("AHD");
            customer.setEmail("ahd123.alhashmi@gmail.com");
            customer.setGender("Female");
            customer.setPhoneNumber(98534911);
            customer.setActive(false);
            customerInterface.save(customer);
        }
    public Customer updateCustomerInformation(String email, Integer phoneNumber,Integer id) throws ParseException {

        Customer customer = customerInterface.getCustomerById(id);
        customer.setEmail("a.m.n.a123@gmail.com");
        customer.setPhoneNumber(97229082);
        customerInterface.save(customer);
        return customer;
    }
}
