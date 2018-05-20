package com.observerPattern;

import java.util.Observable;
import java.util.Observer;

public class TaoBaoObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String newProduct = (String) arg;
        System.out.println("TaoBao商城发布新品" + newProduct);
    }
}
