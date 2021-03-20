package com.griddynamics.demo.rxjava.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SchedulersDemo {

    public static void main(String[] args) throws InterruptedException {
        Observable.just("Spider Man", "Iron Man", "Hulk", "Captain America", "Black Widow", "Black Panther", "Thor")
                .subscribeOn(Schedulers.single())
                .doOnNext(SchedulersDemo::smash)
                .observeOn(Schedulers.io())
                .doOnNext(SchedulersDemo::destroySomeBuilding)
                .observeOn(Schedulers.newThread())
                .subscribe(SchedulersDemo::saveTheWorld);

        Thread.sleep(10000);
    }

    public static void smash(String superhero) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " " + superhero + " smashes!");
    }

    public static void destroySomeBuilding(String superhero) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " " + superhero + " destroyed some building!");
    }

    public static void saveTheWorld(String superhero) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " " + superhero + " saved the world!");
    }
}
