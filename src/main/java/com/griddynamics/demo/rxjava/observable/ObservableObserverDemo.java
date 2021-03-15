package com.griddynamics.demo.rxjava.observable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

public class ObservableObserverDemo {

    public static void main(String[] args) {
        Observable<Integer> source = new ObservableCreate<>(emitter -> {
            try {
                emitter.onNext(10);
                emitter.onNext(20);
                emitter.onNext(30);
                emitter.onComplete();
//                throw new RuntimeException("Error!");
            } catch (Exception ex) {
                emitter.onError(ex);
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Subscribed!");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println("Next: " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.err.println("Error: " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("Completed!");
            }
        };

        source.subscribe(observer);
    }
}
