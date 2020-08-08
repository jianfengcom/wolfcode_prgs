package com.example.day01._06_synchronized;

// 同步锁 互斥锁 同步监听对象 同步监听器
class Apple implements Runnable {
    private int num = 50;

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            synchronized (this) {
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + "吃了苹果:" + num);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num--;
                }
            }
        }
    }
}

public class SynchronizedBlockDemo {
    public static void main(String[] args) {
        Apple apple = new Apple();
        new Thread(apple, "小A").start();
        new Thread(apple, "小B").start();
        new Thread(apple, "小C").start();
    }
}
