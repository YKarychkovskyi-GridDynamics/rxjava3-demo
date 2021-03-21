package com.griddynamics.demo.rxjava.observable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FlowableDemo {

    public static void main(String[] args) {
        Flowable.range(1, 1000000)
                .map(e -> {
                    System.out.println("Produced item is : " + e + " : " + Thread.currentThread().getName());
                    return e;
                })
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<>() {

                               Subscription s;
                               AtomicInteger count = new AtomicInteger(1);

                               @Override
                               public void onSubscribe(Subscription s) {
                                   this.s = s;
                                   System.out.println("Asking for 20 items");
                                   s.request(20);
                               }

                               @Override
                               public void onNext(Integer t) {
                                   int counterValue = count.getAndIncrement();
                                   if (counterValue > 0 && counterValue % 20 == 0) {
                                       System.out.println("Asking for next 20 items ");
                                       s.request(20);
                                   }

                                   System.out.println("The subscriber consumed : " + t);
                                   sleep(100);

                               }

                               @Override
                               public void onError(Throwable t) {
                                   t.printStackTrace();

                               }

                               @Override
                               public void onComplete() {
                                   System.out.println("Completed");

                               }
                           }


                );

        sleep(100000000);
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
