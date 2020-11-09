package com.proxy.dynamicproxy;

public interface Mp {
    public String say(String name);
}

class MpImpl implements Mp{
    public String say(String name){
        System.out.println("进行业务操作"+"say："+name);
        return "梁田";
    }
}