package com.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {

    @org.testng.annotations.Test
    public void userMapperTest(){
        //创建目标对象
        UserMapper um = new UserMapper();

        //创建MyInvocationHandler实例
        InvocationHandler myInvocationHandler = new MyInvocationHandler(um);

        //利用Proxy.newProxyInstance动态生成代理类以及代理对象
        Mapperl mapperl = (Mapperl) Proxy.newProxyInstance(um.getClass().getClassLoader(),
                um.getClass().getInterfaces(), myInvocationHandler );
        System.out.println("mapperl的class类型："+mapperl.getClass().getName());
        mapperl.jdbcOpera();
    }

    @org.testng.annotations.Test
    public void mpTest() {
        //创建目标对象
        MpImpl mpImpl = new MpImpl();
        //创建MyInvocationHandler实例,调用目标对象执行目标对象的方法
        InvocationHandler invocationHandler = new MyInvocationHandler(mpImpl);
        //利用Proxy.newProxyInstance动态生成代理类以及代理对象
        Mp mp =(Mp) Proxy.newProxyInstance(mpImpl.getClass().getClassLoader(),mpImpl.getClass().getInterfaces(),invocationHandler);
        System.out.println("mp的class类型："+mp.getClass().getName());
        //mp的class类型：com.sun.proxy.$Proxy3
        String result = mp.say("余声");
        System.out.println(result);
    }
}
