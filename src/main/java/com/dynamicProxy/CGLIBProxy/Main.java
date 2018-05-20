package com.dynamicProxy.CGLIBProxy;

import org.junit.Test;

public class Main {
    @Test
    public void testCGLIBProxy() {
        CglibProxyExample cglibProxyExample = new CglibProxyExample();
        HelloWorldImpl_2 proxy = (HelloWorldImpl_2) cglibProxyExample.getProxy(HelloWorldImpl_2.class);
        proxy.sayHello("jack");
    }
}
