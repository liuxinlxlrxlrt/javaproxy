package com.proxy.test;

import com.proxy.dynamicproxy.Mapperl;
import com.proxy.util.ProxyClass;

import java.io.IOException;

public class Test02 {
    public static void main(String[] args)throws IOException {
        ProxyClass.createClassFile(Mapperl.class);
    }
}
