package com.observerPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductList extends Observable {
    //产品列表
    private List<String> productList = null;

    //类的唯一实例 这里我用单例模式里的懒汉模式 + 双重校验锁实现
    private static ProductList instance;

    public static ProductList getInstance() {
        if (instance == null) {
            synchronized (ProductList.class) {
                if (instance == null) {
                    instance = new ProductList();
                    instance.productList = new ArrayList<String>();
                }
            }
        }
        return instance;
    }

    //构建方法私有化
    private ProductList() {
    }

    /**
     * 增加观察者（电商接口）
     *
     * @param observer 观察者
     */
    public void addProductListObserver(Observer observer) {
        this.addObserver(observer);
    }

    public void addProduct(String newProduct) {

        productList.add(newProduct);
        System.out.println("产品列表新增了产品：" + newProduct);
        //设置被观察者对象发生变化
        this.setChanged();
        //通知观察者，并传递新产品
        this.notifyObservers(newProduct);
    }

}
