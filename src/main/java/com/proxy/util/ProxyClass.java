package com.proxy.util;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class ProxyClass {
    public static void createClassFile(Class clazz) throws IOException {
        String className = "$Proxy0";
        byte[] classFile = ProxyGenerator.generateProxyClass(className,new Class[] {clazz});

        String path="D:\\AutomationProject\\springboot\\javaproxy\\src\\main\\java\\com\\proxy\\util";

        FileOutputStream outputStream =new FileOutputStream(path+className+".class");
        outputStream.write(classFile);
        outputStream.flush();
        outputStream.close();
    }
}
