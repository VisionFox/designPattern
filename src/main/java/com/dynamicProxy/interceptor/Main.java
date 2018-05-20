package com.dynamicProxy.interceptor;

import com.dynamicProxy.JdkProxy.HelloWorld;
import com.dynamicProxy.JdkProxy.HelloWorldImpl;
import org.junit.Test;

public class Main {
    @Test
    public void testInterceptor() {
        HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),
                "com.dynamicProxy.interceptor.MyInterceptor");

        proxy.sayHello();
    }
}
