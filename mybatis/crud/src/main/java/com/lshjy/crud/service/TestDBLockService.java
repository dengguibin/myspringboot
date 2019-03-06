package com.lshjy.crud.service;

import com.lshjy.crud.mapper.UserMapper;
import com.lshjy.crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
public class TestDBLockService {
    @Autowired
    private UserMapper userMapper;

    private static final Executor exec = Executors.newFixedThreadPool(100);
    /**
     * A线程逐个修改Alluser 的username = userA
     * B线程逐个修改Alluser 的username = userB
     *
     * A,B线程异步执行
     *
     *
     * 现象：虽然A和B都update了allUser，但是不是所有的记录都update success
     *
     */
    public void start(){
        List<User> allUsers = userMapper.selectAllUser();
        for(User user:allUsers){
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    //if age> 0,那么name = A age = age-1 ，并update
                    User userA = userMapper.selectByPrimaryKey(user.getUserId());
                    if (userA.getAge()>0){
                        user.setUserName("A");
                        userA.setAge(user.getAge()-1);
                        userMapper.updateByPrimaryKey(user);
                    }


                }
            };
            exec.execute(task);
        }

        System.out.println("---------------------------------");
        for(User user:allUsers){
            Runnable task = new Runnable() {
                @Override
                public void run() {
//                    addBTran(user);
                    //if age> 0,那么name = A age = age-1 ，并update
                    User userB = userMapper.selectByPrimaryKey(user.getUserId());
                    if (userB.getAge()>0){
                        userB.setUserName("B");
                        userB.setAge(user.getAge()-1);
                        userMapper.updateByPrimaryKey(user);
                    }
                }
            };
            exec.execute(task);
        }


    }

    @Transactional
    public void addBTran(User user){
        //if age> 0,那么name = A age = age-1 ，并update
//        User userB = userMapper.selectByPrimaryKey(user.getUserId());
//        if (userB.getAge()>0){
//            userB.setUserName("B");
//            userB.setAge(user.getAge()-1);
//            userMapper.updateByPrimaryKey(user);
//        }
    }











    public void start1(){
        updateA1();
        updateB1();

    }

    @Async
    public void updateA1(){
        for(int i = 0;i<1000;i++){
            if (i == 500){
                try {
                    Thread.sleep(2000);
                }catch (Exception e){

                }
            }
            System.out.println("我是1="+i);
        }
    }

    @Async
    public void updateB1(){
        for(int i = 0;i<1000;i++){
            System.out.println("我是2="+i);
        }
    }

}
