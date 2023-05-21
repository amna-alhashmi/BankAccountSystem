package com.example.BankAccountSystem.Service;

import com.example.BankAccountSystem.DTO.ReportForAllTransaction;
import com.example.BankAccountSystem.Models.Transaction;
import com.example.BankAccountSystem.Repositoris.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ReportService {
    @Autowired
    AccountInterface accountInterface;
    @Autowired
    CustomerInterface customerInterface;
    @Autowired
    LoanInterface loanInterface;
    @Autowired
    TransactionInterface transactionInterface;
    @Autowired
    CreditCardInterface creditCardInterface;
    public static final String pathToReports = "C:\\Users\\user008\\Downloads\\report";
    public String getGenerateReportForAllTransaction() throws FileNotFoundException, JRException {
        List<Transaction> TransactionList = transactionInterface.getAllTransaction();
        List<ReportForAllTransaction> TransactionsList = new ArrayList<>();

        for (Transaction transaction : TransactionList) {
            Double amount = transaction.getAmount();
            Long accountNumber = transaction.getAccount().getAccountNumber();
            String isActive=transaction.getIsActive();


            ReportForAllTransaction studentDTO = new ReportForAllTransaction(amount, accountNumber, isActive);
            studentDTO.add(studentDTO);
        }
        File file = new File("C:/Users/user008/Downloads/BankAccountSystem/BankAccountSystem/src/main/resources/ReportForAllTransaction.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(TransactionsList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Amna");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\ReportForAllTransaction.pdf");
        return "Report generated : " + pathToReports + "\\ReportForAllTransaction.pdf";
    }

}
