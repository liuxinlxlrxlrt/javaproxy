package com.proxy.staticproxy;

public class UserMapper implements Mapper {
    public void jdbcOperator(){
        System.out.println("---UserMapper执行核心代码---");
    }
}
