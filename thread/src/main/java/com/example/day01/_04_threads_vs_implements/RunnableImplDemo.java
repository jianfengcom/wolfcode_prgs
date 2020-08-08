package com.example.day01._04_threads_vs_implements;

class Apple implements Runnable {
    private int num = 50;

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "吃了苹果:" + num--);
            }
        }
    }
}

public class RunnableImplDemo {
    public static void main(String[] args) {
        Apple apple = new Apple();
        new Thread(apple, "小A").start();
        new Thread(apple, "小B").start();
        new Thread(apple, "小C").start();
    }
}
