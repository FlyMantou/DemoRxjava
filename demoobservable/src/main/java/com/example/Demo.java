package com.example;

/**
 * Created by Administrator on 2017/4/2.
 */

public class Demo {
    public static  void main(String[] args){
        //1创建可观察对象
        Observable observable = new Observable();
        //2创建多个观察者处理变化
        SmsObserver smsObserver = new SmsObserver();
        EmailObserver emailObserver = new EmailObserver();

        //3要求 订阅
        observable.subscribe(smsObserver);
        observable.subscribe(emailObserver);

        System.out.println("first---start");
        observable.setMoney(1000);
        System.out.println("first---end");

        System.out.println("second---start");

        observable.setMoney(1);
        System.out.println("second---end");
    }
}
