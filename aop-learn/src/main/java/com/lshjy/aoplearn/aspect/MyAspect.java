package com.lshjy.aoplearn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;

@Aspect//这是一个切面
@Component//告诉Spring需要将其加入到IOC容器
public class MyAspect {

//    @Pointcut("execution(public * com.lshjy.aoplearn.service..*.*(..))")
//    @Pointcut("@args(com.lshjy.aoplearn.annotation.Monitorable)")
//    public void pointCut1(){
//
//    }
//
//    @Pointcut("@annotation(com.lshjy.aoplearn.annotation.NeedTest)")
//    public void pointCut2(){
//
//    }
//
//    @Pointcut("execution(public * *(..))")
    @Pointcut("execution(public * com.lshjy.aoplearn.controller..*.*(..))")
    public void pointCut3(){

    }
//
//    @Pointcut("execution(* *ay(..))")
//    public void pointCut4(){
//
//    }
//
//    @Pointcut("execution(* com.lshjy.aoplearn.inter.Inter1.*(..))")
//    public void pointCut5(){
//
//    }
//
//    @Pointcut("execution(* com.lshjy.aoplearn.inter.Inter1+.*(..))")
//    public void pointCut6(){
//
//    }
//
//    @Pointcut("execution(* com.lshjy.aoplearn.inter.*(..))")
//    public void pointCut7(){
//
//    }
//
//    @Pointcut("execution(* com.lshjy.aoplearn.inter..*(..))")
//    public void pointCut8(){
//
//    }
//
//    @Pointcut("execution(* com..*.*Dao.find*(..))")
//    public void pointCut9(){
//
//    }
//
//    @Pointcut("execution(* joke(String,int))")
//    public void pointCut10(){
//
//    }
//
//    @Pointcut("execution(* joke(String,*))")
//    public void pointCut11(){
//
//    }
//
//    @Pointcut("execution(* joke(String,..))")
//    public void pointCut12(){
//
//    }
//
//    @Pointcut("execution(* joke(Object+))")
//    public void pointCut13(){
//
//    }
//
//    //================下面不重要
//    @Pointcut("args(com.lshjy.aoplearn.inherit.Waiter)")
//    public void pointCut14(){
//
//    }
//
//    /**
//     * 方法入参类型必须高于Monitorable注解解释的类
//     */
//    @Pointcut("@args(com.lshjy.aoplearn.annotation.Monitorable)")
//    public void pointCut15(){
//
//    }
//
//    @Pointcut("within(com.lshjy.aoplearn.inherit.Waiter)")
//    public void pointCut16(){
//
//    }
//
//    @Pointcut("within(com.lshjy.aoplearn.inherit.*)")
//    public void pointCut17(){
//
//    }
//
//    @Pointcut("within(com.lshjy.aoplearn.inherit..*)")
//    public void pointCut18(){
//
//    }
//
//    @Pointcut("@within(com.lshjy.aoplearn.annotation.Monitorable)")
//    public void pointCut19(){
//
//    }
//
//    @Pointcut("@target(com.lshjy.aoplearn.annotation.Monitorable)")
//    public void pointCut20(){
//
//    }
//
//    @Pointcut("target(com.lshjy.aoplearn.inherit.Waiter)")
//    public void pointCut21(){
//
//    }
//
//    @Pointcut("this(com.lshjy.aoplearn.inherit.Waiter)")
//    public void pointCut22(){
//
//    }





//    @Before(value = "pointCut3()")
//    public void doBefore(JoinPoint joinPoint) {
//        System.out.println("前置增强");
//        Object[] obje = joinPoint.getArgs();
//        Signature signature = joinPoint.getSignature();
//        Object target = joinPoint.getTarget();
//        Object object = joinPoint.getThis();
//        HttpServletRequest request = (HttpServletRequest)obje[1];
//        System.out.println(request.getRequestURI());
//        System.out.println(signature.getName());
//        System.out.println(target);
//        System.out.println(object);
//    }
//
//    @AfterReturning(value = "pointCut4()")
//    public void after(JoinPoint joinPoint) {
//        System.out.println("后置增强");
//    }
//
//    @Around(value = "pointCut3()")
//    public void doAround(ProceedingJoinPoint pjp) throws Throwable{
//        System.out.println("环绕前");
//        pjp.proceed();
//        System.out.println("环绕后");
//    }

    @AfterThrowing(pointcut="pointCut3()",throwing = "exception")
    public void doAfterThrow(JoinPoint joinPoint,Throwable exception) {
        //记录空指针异常
        if (exception instanceof Exception) {
            Object[] obje = joinPoint.getArgs();//方法入参列表
            Signature signature = joinPoint.getSignature();//方法签名对象
            Object target = joinPoint.getTarget();//连接点所在目标对象
            Object object = joinPoint.getThis();//获取代理对象本身

            System.out.println(signature.getName());
            System.out.println(target);
            System.out.println(object);
        }
    }
}
