package com.griddynamics.demo.rxjava.observable;

import io.reactivex.rxjava3.core.Observable;

import java.util.Random;

public class OperatorsInAction {

    public static void main(String[] args) {
        var random = new Random();

        Observable.<Integer>generate(emitter -> emitter.onNext(random.nextInt(100)))
                .take(20)
                .filter(value -> value % 2 == 0)
                .map(integer -> "Transformed: " + integer)
                .subscribe(System.out::println);
    }
}
