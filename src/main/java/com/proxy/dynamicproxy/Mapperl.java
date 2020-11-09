package com.proxy.dynamicproxy;

public interface Mapperl {
    public void jdbcOpera();
}

class UserMapper implements Mapperl{
    public void jdbcOpera(){
        System.out.println("---UserMapper执行核心代码---");
    }
}

class AdminMapper implements Mapperl{
    public void jdbcOpera(){
        System.out.println("---AdminMapper执行核心代码---");
    }
}

