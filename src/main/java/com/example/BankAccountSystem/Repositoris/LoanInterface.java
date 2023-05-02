package com.example.BankAccountSystem.Repositoris;

import com.example.BankAccountSystem.Models.Loan;
import org.springframework.data.repository.CrudRepository;

public interface LoanInterface extends CrudRepository<Loan,Integer> {
}
