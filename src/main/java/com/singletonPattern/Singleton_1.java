package com.singletonPattern;

/**
 * 懒汉模式（需要时才创建实例,延迟加载），多线程情况下不安全
 */
public class Singleton_1 {
    private static Singleton_1 instance;

    private Singleton_1() {
    }

    public static Singleton_1 getInstance() {
        if (instance == null) {
            instance = new Singleton_1();
        }
        return instance;
    }
}
