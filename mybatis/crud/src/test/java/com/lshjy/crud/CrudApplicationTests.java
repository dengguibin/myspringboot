package com.lshjy.crud;

import com.lshjy.crud.mapper.UserMapper;
import com.lshjy.crud.model.User;
import com.lshjy.crud.service.TestDBLockService;
import com.lshjy.crud.service_transaction.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
@EnableTransactionManagement
public class CrudApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TestDBLockService dbLockService;

    @Autowired
    private TransactionService service;
    @Test
    public void contextLoads() throws Exception{
        service.test3();

    }


    @Test
    public void transactionTest() {
        service.test2();
    }

    @Test
    public void transactionTest2() {
        service.updateUser();
    }

    @Test
    public void transactionTest3() {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

}

