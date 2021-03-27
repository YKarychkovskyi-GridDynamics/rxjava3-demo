package com.griddynamics.demo.rxjava.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class HotObservableDemo {

    public static void main(String[] args) throws InterruptedException {
        ConnectableObservable<Long> hotObservable = Observable.interval(500, TimeUnit.MILLISECONDS).publish();

        hotObservable.subscribe(System.out::println);

        hotObservable.connect();

        Thread.sleep(5000);

        System.out.println("-----------------------");

        hotObservable.subscribe(System.out::println);

        Thread.sleep(5000);
    }
}
