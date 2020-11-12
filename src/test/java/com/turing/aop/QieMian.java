package com.turing.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面类拦截
 * 1.我想在spring的容器内（
 * (1).需要注解：@Component，将类在加到spring容器内，
 * (2).还需要扫描到，在apllicationContext.xml中添加对应的包名
 * <context:component-scan base-package="com.turing.manage.service.impl,com.turing.aop"></context:component-scan>
 * 2.实现AOP的功能
 * (1).定义为切面类，加注解：@Aspect
 */
@Component
@Aspect
public class QieMian {
    //拦截谁，怎么拦截？
    //切入点：用的是反射方法，写清楚返回值类型、方法全路径、参数类型
    //@Pointcut放在方法上
    //拦截一个方法
    @Pointcut("execution(void com.turing.manage.service.impl.LuBianTanServiceImpl.maiKaoChuan(Integer))")
    public void any() {
    }

    //拦截完干是什么
    //@Around 环绕通知
    //ProceedingJoinPoint
    @Around("any()")
    public Object lanjie(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("我来拦截了，不让方法运行了");
        //获取切入点所在目标对象
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        System.out.println(className);

        //获取切入点方法的名字
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println(methodName);

        //获取方法的参数
        Object[] objects = proceedingJoinPoint.getArgs();
        System.out.println(Arrays.toString(objects));

        //执行拦截点（执行被拦截的方法）
        Object result = null;
        try {
            //可改变参数
            objects[0] = 100;
            //1.连接点执行前
            System.out.println("环绕+前置");
            result = proceedingJoinPoint.proceed(objects);
            //2.连接点执行后
            System.out.println("环绕+后置");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //3.连接点发生异常
            System.out.println("环绕+异常");
        }finally {
            //4.最终会执行这里
            System.out.println("环绕+最终");
        }
        return result;
    }

    @Before("any()")
    public void qianzhi(JoinPoint joinPoint){
        System.out.println("前置通知");
    }

    @AfterReturning("any()")
    public void houzhi(JoinPoint joinPoint){
        System.out.println("后置通知");
    }

    @AfterThrowing("any()")
    public void yichang(JoinPoint joinPoint){
        System.out.println("异常通知");
    }

    @After("any()")
    public void zuizhong(JoinPoint joinPoint){
        System.out.println("最终通知");
    }
}
