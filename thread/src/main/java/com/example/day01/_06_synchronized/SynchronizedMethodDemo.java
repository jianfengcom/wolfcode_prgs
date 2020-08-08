package com.example.day01._06_synchronized;

class Apple2 implements Runnable {
    private int num = 50;

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            eat();
        }
    }

    synchronized private void eat() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "吃了apple:" + num);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num--;
        }
    }
}

public class SynchronizedMethodDemo {
    public static void main(String[] args) {
        Apple2 apple = new Apple2();
        new Thread(apple, "小A").start();
        new Thread(apple, "小B").start();
        new Thread(apple, "小C").start();
    }
}
