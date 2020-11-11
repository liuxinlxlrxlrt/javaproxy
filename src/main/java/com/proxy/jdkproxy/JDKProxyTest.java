package com.proxy.jdkproxy;

import java.lang.reflect.Method;

public class JDKProxyTest {
    public static void main(String[] args) throws Exception{
        //反射调用
//        Object object = new JdkMeipo().getInstrance(new Girl());
//        Method method = object.getClass().getMethod("findLove",null);
//        method.invoke(object);

        Person person = new JdkMeipo().getInstrance(new Girl());
        person.findLove();

    }
}
