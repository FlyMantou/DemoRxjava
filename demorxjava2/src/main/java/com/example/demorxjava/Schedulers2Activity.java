package com.example.demorxjava;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class Schedulers2Activity extends AppCompatActivity {

    private Observable<Integer> observable;
    private Subscriber<String> subscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //使用lambda表达式
        //new Thread(()-> System.out.print("hello lambda")).start();


       /* subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Toast.makeText(Schedulers2Activity.this,"接收完成",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(Schedulers2Activity.this,"接收异常",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(String data) {
                Toast.makeText(Schedulers2Activity.this,"数据："+data,Toast.LENGTH_SHORT).show();
            }
        };*/
      // Observable.timer(4, TimeUnit.SECONDS).subscribe(timeLong->enterApp());
        Observable.interval(5,TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(timeLong->enterApp());
       // System.out.print("hello main");
        Log.i("huanghai","sdaasd");
        //Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();
    }

    public void start(View v){
        Integer numbers[] = {1,2,3,4,5};
        observable = Observable.from(numbers);


        observable.filter(t1->t1%2==0)
                .scan((sum,item)->sum+item)
                .map(t1->t1+"")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s ->System.out.print("hello action use:"+s));
    }
    private void printThread(String message){
        System.out.println("method:"+message+"current Thread:"+Thread.currentThread().getName());
    }
    private void enterApp(){
        Log.i("huanghai","hahahahahahahaha");
        //System.out.print("nihao,system");
        Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();
    }
}
