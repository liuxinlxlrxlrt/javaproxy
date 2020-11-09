package com.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * invoke方法是用于进行增强处理的
     * @param proxy 在内存中动态生成代理类的实例
     * @param method 当前目标对象正在执行的方法
     * @param args 当前目标对象正在执行的方法的参数
     * @return
     * @throws Throwable
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("method："+method.getName()+"，args："+args[0]);
        System.out.println("获取连接");

        //通知 目标对象
        Object invoke = method.invoke(target, args);

        System.out.println("关闭连接");
        return invoke;
    }
}
