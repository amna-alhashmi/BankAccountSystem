package com.example.BankAccountSystem.Controller;

import com.example.BankAccountSystem.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Report")
public class ReportController {
@Autowired
    ReportService reportService;
    @RequestMapping(value = "GenerateReportForAllTransaction",method = RequestMethod.GET)

    public void getGenerateReportForAllTransaction() throws Exception{

        reportService.getGenerateReportForAllTransaction();
    }
}
