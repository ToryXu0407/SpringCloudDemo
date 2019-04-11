package com.toryxu.ribbonconsumer;


import rx.Observable;
import rx.Subscriber;

/**
 * @Author: toryxu
 * @Date: 2019/4/11 0011 15:03
 * @Version 1.0
 * RxJava的观察者-订阅者模式demo
 * 观察者通知订阅者，然后跑call方法，在call方法中根据执行订阅者的方法。
 * 就是命令模式
 * A通知B去干事，但是A不知道B的具体实现。
 */
public class rxjava {
    public static void main(String[] args) {
        //创建事件源
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>(){
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello RxJava");
                subscriber.onNext("I AM TORYXU");
                subscriber.onCompleted();
            }
        });
        //创建订阅者subscriber
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("Subscriber:"+s);
            }
        };
        observable.subscribe(subscriber);

    }
}
