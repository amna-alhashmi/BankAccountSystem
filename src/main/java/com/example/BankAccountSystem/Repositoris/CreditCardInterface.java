package com.example.BankAccountSystem.Repositoris;

import com.example.BankAccountSystem.Models.CreditCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CreditCardInterface extends CrudRepository<CreditCard,Integer> {
    @Query(value = "SELECT c.isActive from CreditCard c where c.id =:creditCardId")
    Boolean getStatusOfCreditCardApplication(@Param("creditCardId")Integer id);
}
