package com.example.BankAccountSystem.Repositoris;

import com.example.BankAccountSystem.Models.Account;
import com.example.BankAccountSystem.Models.Customer;
import com.example.BankAccountSystem.Models.Transaction;
import org.springframework.beans.factory.annotation.Value;
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
    @Query(value="SELECT id from account  where account_number= :accountNumber", nativeQuery = true)
    Integer getAccountId(@Param("accountNumber") Long account_number);

    @Query(value="SELECT s from Account s where s.id= :AccountId")
    Account geId(@Param("AccountId") Integer AccountId);
    @Query(value ="SELECT s.balance from Account s where s.accountNumber= :AccountNumber")
    Double getAccountBalanceForSpecificAccount(@Param("AccountNumber") Long AccountNumber);
//    @Query(value="SELECT id from customer  where customer_name= :customerName", nativeQuery = true)
//    Integer getCustomerId(@Param("customerName") String customer_name);
}
