package com.lshjy.crud.controller;

import com.lshjy.crud.model.User;
import com.lshjy.crud.service_transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionTestController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/executeQuery")
    public User executeQuery(){
        return transactionService.queryUserSleep();
    }

    @GetMapping("/executeUpdate")
    public void executeUpdate(){
        transactionService.updateUser();
    }

    @GetMapping("/update1")
    public User update1(){
        return transactionService.update1();
    }

    @GetMapping("/update2")
    public User update2(){
        return transactionService.update2();
    }

}
