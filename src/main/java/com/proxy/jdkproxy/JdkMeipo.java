package com.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkMeipo implements InvocationHandler {

    private Person target;

    public Person getInstrance(Person persion){
        this.target = persion;
        Class<?> clazz = target.getClass();
        return (Person) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        Object invoke = method.invoke(target, args);
        after();
        return invoke;
    }

    public void before(){
        System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色");
    }

    public void after(){
        System.out.println("已经找到，ok的话，准备办事");
    }
}
