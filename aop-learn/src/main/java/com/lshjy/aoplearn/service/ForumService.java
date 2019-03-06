package com.lshjy.aoplearn.service;

import com.lshjy.aoplearn.annotation.NeedTest;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service
public class ForumService {
    @NeedTest(value = true)
    public void m1(){
        System.out.println("m111111111");
    }

    @NeedTest(value = false)
    public void m2(){
        System.out.println("m222222222");
    }

    public static void main(String[] args) {
        Class clazz = ForumService.class;
        clazz.getDeclaredAnnotations();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method:methods){
            NeedTest nt = method.getAnnotation(NeedTest.class);
            if (nt!=null){
                if (nt.value()){
                    System.out.println("需要测试");
                }else {
                    System.out.println("不需要测试");
                }
            }
        }

    }
}
