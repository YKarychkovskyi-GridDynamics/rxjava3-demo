package com.griddynamics.demo.rxjava.observable;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;

public class ColdObservableDemo {

    public static void main(String[] args) {
        var list = new ArrayList<Integer>(4);
        list.add(1);
        list.add(2);
        list.add(3);

        Observable.fromIterable(list)
                .subscribe(System.out::println);

        System.out.println("-----------------------");

        list.add(4);
        Observable.fromIterable(list)
                .subscribe(System.out::println);

    }
}
