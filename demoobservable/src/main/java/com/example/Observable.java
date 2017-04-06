package com.example;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/4/2.
 */

public class Observable {
    private double money;

    private List<Observer> observers = new ArrayList<>();
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
        //通知所有的观察者
        notifyAllObservers(money);
    }

    private void notifyAllObservers(double money) {
        for (Observer item:observers){
            item.update(money);
        }
    }

    public void subscribe(Observer observer){
        observers.add(observer);
    }

    public void unSubscribe(Observer observer){
        if(observers.contains(observer)){
            observers.remove(observer);
        }
    }
}
