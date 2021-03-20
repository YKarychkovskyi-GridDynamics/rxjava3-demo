package com.griddynamics.demo.rxjava.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class BufferingDemo {

    public static void main(String[] args) throws InterruptedException {
        Observable.range(1, 30)
                .buffer(4)
                .subscribe(list -> System.out.println(list));

        System.out.println("----------- Time constraint ----------");
        Observable.interval(500, TimeUnit.MILLISECONDS)
                .buffer(2, TimeUnit.SECONDS)
                .subscribe(list -> System.out.println(list));

        Thread.sleep(10000);
    }
}
