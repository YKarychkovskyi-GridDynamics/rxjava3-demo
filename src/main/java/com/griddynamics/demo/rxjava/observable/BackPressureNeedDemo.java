package com.griddynamics.demo.rxjava.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class BackPressureNeedDemo {

    public static void main(String[] args) throws InterruptedException {
        Observable.interval(100, TimeUnit.MILLISECONDS)
                .doOnNext(elem -> System.out.println("Produced item: " + elem + "; Thread: " + Thread.currentThread().getName()))
                .observeOn(Schedulers.io())
                .subscribe(elem -> {
                    Thread.sleep(1000);
                    System.out.println("Consumed item: " + elem+ "; Thread: " + Thread.currentThread().getName());
                });

        Thread.sleep(10000);
    }
}
