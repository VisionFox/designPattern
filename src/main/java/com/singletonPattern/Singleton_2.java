package com.singletonPattern;

/**
 * 懒汉模式二，singleton_1的升级版，在方法名前加了synchronized保证线程安全,但效率低，每条线程都有阻塞等待
 */
public class Singleton_2 {
    private static Singleton_2 instance;

    private Singleton_2() {
    }

    public synchronized static Singleton_2 getInstance() {
        if (instance == null) {
            instance = new Singleton_2();
        }
        return instance;
    }
}
