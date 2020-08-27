package com.example.expand;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) {
        MyCallable ca = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(ca);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i== 30) {
                Thread t = new Thread(ft);
                t.start();
            }
        }

        System.out.println("主线程for循环执行完毕...");

        try {
            System.out.println(1);
            System.out.println(ft.get()); // ft.get()方法会一直阻塞，直到call()方法执行完毕才能取到返回值
            System.out.println(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyCallable implements Callable<Integer> {
    private int i;

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            sum += i;
        }
        return sum;
    }
}
