package com.proxy.test;

import com.proxy.staticproxy.AdminMapper;
import com.proxy.staticproxy.Mapper;
import com.proxy.staticproxy.StaticProxy;
import com.proxy.staticproxy.UserMapper;

public class Test {

    @org.testng.annotations.Test
    public void staticProxyTest(){
        //创建目标对象
        UserMapper userMapper = new UserMapper();

        //创建代理
        StaticProxy staticProxy= new StaticProxy(userMapper);

        staticProxy.jdbcOperator();

        System.out.println("--------------------------------");

        AdminMapper adminMapper = new AdminMapper();

        StaticProxy staticProxy1 = new StaticProxy(adminMapper);

        staticProxy.jdbcOperator();

    }
}
