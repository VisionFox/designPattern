package com.singletonPattern;

/**
 * 枚举
 * 这种方式是[Effective Java - Joshua Bloch](https://www.amazon.cn/dp/B01DPUXUWG/ref=sr_1_2?ie=UTF8&qid=1486966767&sr=8-2&keywords=Effective+Java)提倡的方式，
 * 使用枚举，除了线程安全和防止反射强行调用构造器之外，还提供了自动序列化机制，防止反序列化的时候创建新的对象。
 * 因此，Effective Java 推荐尽可能地使用枚举来实现单例。
 * 注意：枚举，虽然Effective Java中推荐使用，但是在Android平台上却是不被推荐的。
 */
public enum Singleton_5 {
    INSTANCE;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
