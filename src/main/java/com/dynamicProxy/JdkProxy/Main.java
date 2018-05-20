package com.dynamicProxy.JdkProxy;


import org.junit.Test;

public class Main {

    @Test
    public void testJdkProxy() {
        //new jdk代理工具类
        JdkProxyExample jdkProxyExample = new JdkProxyExample();
        //绑定并返回代理对象
        HelloWorld proxy = (HelloWorld) jdkProxyExample.bind(new HelloWorldImpl());
        //代理对象运行会进入代理逻辑方法
        proxy.sayHello();
    }
}