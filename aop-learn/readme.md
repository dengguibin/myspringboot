弃用jdk动态代理，使用cglib代理

自定义注解（没有注解处理器，但是有切面处理注解的方法） 
 
使用AspectJ实现AOP

前置增强，后置增强，环绕增强，异常增强

切面：增强+切点

获得连接点信息：
    
    JoinPoint.getXXX
    ProceedingJoinPoint，☆可以使用新的入参替换原来的入参

切点深入：请看MyAspect的pointCut方法