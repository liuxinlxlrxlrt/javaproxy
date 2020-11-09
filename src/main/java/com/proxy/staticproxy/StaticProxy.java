package com.proxy.staticproxy;

public class StaticProxy {
    private Mapper mapper;

    public StaticProxy(Mapper mapper) {
        this.mapper = mapper;
    }

    public void jdbcOperator(){
        getConnection();
        mapper.jdbcOperator();
        closeConnection();
    }

    public void getConnection(){
        System.out.println("获取连接");
    }

    public void closeConnection(){
        System.out.println("关闭连接");
    }
}
