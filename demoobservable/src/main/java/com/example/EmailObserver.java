package com.example;

/**
 * Created by Administrator on 2017/4/2.
 */

public class EmailObserver implements Observer {
    @Override
    public void update(Object newData) {
        System.out.print("Smsobserver:send email to user:"+newData);
    }
}
