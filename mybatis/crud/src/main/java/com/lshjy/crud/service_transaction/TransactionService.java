package com.lshjy.crud.service_transaction;

import com.lshjy.crud.mapper.UserMapper;
import com.lshjy.crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响


    @Transactional
    public void test3() throws Exception{
        userMapper.deleteByPrimaryKey(2);
//        int i = 1/0;
    }



    /**
     * 如果另起一个线程，事务是否能够管到
     */
    @Transactional
    public void test(){
        userMapper.deleteByPrimaryKey(1);//可以执行
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("dddddddddddddddddd");
                        userMapper.deleteByPrimaryKey(1);//不会执行？？？？？？？
                    }
                }
        ).start();
    }

    public void test2(){
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        del();
                    }
                }
        ).start();
    }

    @Transactional
    public void del(){
        userMapper.deleteByPrimaryKey(2);//可以执行
    }

    /**
     * 测试事务是否也会有并发问题
     *
     * 1.先执行方法 queryUserSleep 休眠后查询user（1）
     * 2.再执行 updateUser 修改user（1）
     */
    @Transactional
    public User queryUserSleep(){
        try {
            Thread.sleep(10000);
        }catch (Exception e){

        }

        return userMapper.selectByPrimaryKey(1);
    }

    @Transactional
    public void updateUser(){
        User user = new User();
        user.setUserId(1);user.setUserName("我是改变之后的name1");
        userMapper.updateByPrimaryKeySelective(user);
    }
    @Transactional
    public User update1(){
        try {
            Thread.sleep(10000);
        }catch (Exception e){

        }

        User user = new User();
        user.setUserId(1);user.setUserName("xxx");
        userMapper.updateByPrimaryKeySelective(user);
        return userMapper.selectByPrimaryKey(1);

    }

    @Transactional
    public User update2(){
        User user = new User();
        user.setUserId(1);user.setUserName("yyy");
        userMapper.updateByPrimaryKeySelective(user);
        return userMapper.selectByPrimaryKey(1);
    }
}
