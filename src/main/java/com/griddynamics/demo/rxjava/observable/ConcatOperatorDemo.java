package com.griddynamics.demo.rxjava.observable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ConcatOperatorDemo {

    public static void main(String[] args) throws InterruptedException {
        @NonNull Observable<String> eachSecond = Observable.interval(1, TimeUnit.SECONDS)
                .map(value -> "Observer1: " + value).take(3);
        @NonNull Observable<String> eachTwoSeconds = Observable.interval(2, TimeUnit.SECONDS)
                .map(value -> "Observer2: " + value);
        Observable.concat(eachSecond, eachTwoSeconds)
                .subscribe(System.out::println);

        Thread.sleep(10000);
    }
}
