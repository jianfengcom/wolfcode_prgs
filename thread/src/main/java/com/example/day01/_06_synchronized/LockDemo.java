package com.example.day01._06_synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Apple3 implements Runnable {
    private int num = 50;
    final private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            eat();
        }
    }

    private void eat() {
        lock.lock();
        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "吃了Up破:" + num);
                Thread.sleep(40);
                num--;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class LockDemo {
    public static void main(String[] args) {
        Apple3 apple = new Apple3();
        new Thread(apple, "小A").start();
        new Thread(apple, "小B").start();
        new Thread(apple, "小C").start();
    }
}
