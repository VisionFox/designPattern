package com.singletonPattern;

/**
 * 饿汉
 * 饿汉法就是在第一次引用该类的时候就创建对象实例，而不管实际是否需要创建
 * 好处是编写简单，但是无法做到延迟创建对象
 */
public class Singleton_4 {
    private final static Singleton_4 instance = new Singleton_4();

    private Singleton_4() {
    }

    public static Singleton_4 getInstance() {
        return instance;
    }
}
