package com.example.BankAccountSystem.Repositoris;

import com.example.BankAccountSystem.Models.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerInterface extends CrudRepository<Customer,Integer> {
    @Query(value = "SELECT s FROM Customer s WHERE s.customerName= :customerName")
    Customer getCustomerName(@Param("customerName") String customerName);
}
