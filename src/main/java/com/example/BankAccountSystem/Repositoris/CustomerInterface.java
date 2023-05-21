package com.example.BankAccountSystem.Repositoris;

import com.example.BankAccountSystem.Models.Account;
import com.example.BankAccountSystem.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerInterface extends JpaRepository<Customer,Integer> {
    @Query(value = "SELECT s FROM Customer s WHERE s.customerName= :customerName")
    Customer getCustomerName(@Param("customerName") String customerName);
    @Query(value="SELECT id from customer  where customer_name= :customerName", nativeQuery = true)
    Integer getCustomerId(@Param("customerName") String customer_name);

    @Query(value="SELECT s from Customer s where s.id= :customerId")
    Customer geId(@Param("customerId") Integer customerId);
    @Query(value = "SELECT s FROM Customer s WHERE s.id= :CustomerId")
    Customer getCustomerById(@Param("CustomerId")Integer id);

    @Query(value = "SELECT s FROM Account s WHERE s.customer.id= :CustomerId")
    List<Customer> getCustomerAccountInformationByCustomerId(@Param("CustomerId")Integer id);

}
