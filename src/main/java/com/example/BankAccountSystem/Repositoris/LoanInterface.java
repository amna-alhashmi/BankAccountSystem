package com.example.BankAccountSystem.Repositoris;

import com.example.BankAccountSystem.Models.Loan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface LoanInterface extends CrudRepository<Loan,Integer> {
    @Query(value = "SELECT is_active from loan  where id= :loanId", nativeQuery = true)
    Boolean getStatusOfLoanApplication(@Param("loanId")Integer id);
}
