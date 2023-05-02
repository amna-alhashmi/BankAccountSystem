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
public interface AccountInterface extends CrudRepository<Account,Integer> {
    @Query(value = "SELECT s FROM Account s where s.accountNumber= :accountnumber")
    List<Account> getAllCustomerAccount(@Param("accountnumber")Long accountnumber);

//    @Query(value="SELECT id from customer  where customer_name= :customerName", nativeQuery = true)
//    Integer getCustomerId(@Param("customerName") String customer_name);
}
