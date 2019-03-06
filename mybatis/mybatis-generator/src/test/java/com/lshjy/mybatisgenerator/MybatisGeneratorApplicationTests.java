package com.lshjy.mybatisgenerator;

import com.lshjy.mybatisgenerator.mapper.UserMapper;
import com.lshjy.mybatisgenerator.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisGeneratorApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void generator() {
        List<User> users = userMapper.selectAllUser();
        System.out.println(users.size());
    }

}

