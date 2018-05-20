package com.observerPattern;

import org.junit.Test;

public class Main {
    @Test
    public void testObserverPattern() {
        ProductList observable = ProductList.getInstance();

        TaoBaoObserver taoBaoObserver = new TaoBaoObserver();
        JingdongObserver jingdongObserver = new JingdongObserver();

        observable.addObserver(taoBaoObserver);
        observable.addObserver(jingdongObserver);

        observable.addProduct("哇哈哈");
    }
}
