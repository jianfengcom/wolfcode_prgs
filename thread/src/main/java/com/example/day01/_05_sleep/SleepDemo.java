package com.example.day01._05_sleep;

/*
System.out.println(Thread.currentThread().getName() + "吃了苹果" + num--);

步骤:
num
num - 1
展示 num

如:
小C吃了苹果1
小A吃了苹果-1
小B吃了苹果0

c3 b2 a3 b3
*/

/**
 * 一睡就出事
 */
class Apple implements Runnable {
    private int num = 50;
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (num > 0) {
                try {
                    Thread.sleep(30); // 模拟网络延迟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "吃了苹果" + num--);
            }
        }
    }
}

public class SleepDemo {
    public static void main(String[] args) {
        Apple apple = new Apple();
        new Thread(apple, "小A").start();
        new Thread(apple, "小B").start();
        new Thread(apple, "小C").start();
    }
}

