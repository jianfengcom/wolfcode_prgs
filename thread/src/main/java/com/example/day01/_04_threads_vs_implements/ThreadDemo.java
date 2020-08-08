package com.example.day01._04_threads_vs_implements;

class Person extends Thread {
    private int num = 50;

    public Person(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (num > 0) {
                System.out.println(super.getName() + "吃了苹果:" + num--);
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        new Person("小A").start();
        new Person("小B").start();
        new Person("小C").start();
    }
}
