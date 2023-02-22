package com.emnets.demoreactor.reactor8;

import java.util.Observable;

/**
 * @author lannisite
 * @program ObserverDemo
 * @description 描述
 * @date 2023/2/21 23:16
 */

public class ObserverDemo extends Observable {


    public static void main(String[] args) {
        ObserverDemo observer = new ObserverDemo();

        //  添加观察者
        observer.addObserver((o,arg)->{
            System.out.println("发生了变化");
        });

        observer.addObserver((o,arg)->{
            System.out.println("收到被观察者的通知，准备改变");
        });

        //  数据变化
        observer.setChanged();
        //  通知变化，将变化传播
        observer.notifyObservers();
    }
}
