package com.dynamicProxy.JdkProxy;

public class HelloWorldImpl implements HelloWorld{

    @Override
    public void sayHello() {
        System.out.println("HelloWorld");
    }
}
