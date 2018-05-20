package com.dynamicProxy.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorJdkProxy implements InvocationHandler {
    //真实对象
    private Object target;
    //拦截器全限定名
    private String interceptorClass = null;

    public InterceptorJdkProxy(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    /**
     * 绑定委托对象并返回一个【代理占位（代理对象）】
     *
     * @param target           真实对象
     * @param interceptorClass 拦截器的全限定名
     * @return 代理对象
     */
    public static Object bind(Object target, String interceptorClass) {
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InterceptorJdkProxy(target, interceptorClass));
    }

    /**
     * 通过代理对象调用方法，首先进入这个方法
     *
     * @param proxy  代理对象
     * @param method 方法，被调用的方法
     * @param args   方法的参数
     * @return
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //没有拦截器则直接反射原有方法
        if (interceptorClass == null) {
            return method.invoke(target, args);
        }

        Object result = null;
        //通过反射生成拦截器
        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();

        if (interceptor.before(proxy, target, method, args)) {
            //反射原有方法
            result = method.invoke(target, args);
        } else {
            //返回false执行around方法
            interceptor.around(proxy, target, method, args);
        }
        //调用后置方法
        interceptor.after(proxy, target, method, args);
        return result;
    }
}
