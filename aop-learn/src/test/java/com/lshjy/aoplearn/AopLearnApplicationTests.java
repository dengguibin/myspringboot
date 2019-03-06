package com.lshjy.aoplearn;

import com.lshjy.aoplearn.controller.TestController;
import com.lshjy.aoplearn.service.ForumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopLearnApplicationTests {

    @Autowired
    private ForumService forumService;

    @Autowired
    private TestController controller;

    @Test
    public void contextLoads() {
        controller.say();
    }

}
