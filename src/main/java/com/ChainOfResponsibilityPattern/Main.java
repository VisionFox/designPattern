package com.ChainOfResponsibilityPattern;

import com.dynamicProxy.JdkProxy.HelloWorld;
import com.dynamicProxy.JdkProxy.HelloWorldImpl;
import com.dynamicProxy.interceptor.InterceptorJdkProxy;
import org.junit.Test;

public class Main {
    @Test
    public void testChainOfResponsibility() {
        HelloWorld proxy1 = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),
                "com.ChainOfResponsibilityPattern.Interceptor1");

        HelloWorld proxy2 = (HelloWorld) InterceptorJdkProxy.bind(proxy1,
                "com.ChainOfResponsibilityPattern.Interceptor2");

        HelloWorld proxy3 = (HelloWorld) InterceptorJdkProxy.bind(proxy2,
                "com.ChainOfResponsibilityPattern.Interceptor3");

        proxy3.sayHello();
    }
}
