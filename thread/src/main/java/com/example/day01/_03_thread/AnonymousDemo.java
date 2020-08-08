package com.example.day01._03_thread;

/**
 * 匿名线程
 */
public class AnonymousDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            System.out.println("打游戏:" + i);
            if (i == 4) {
                /*new Thread() {
                    @Override
                    public void run() {
                        for (int i = 1; i <= 50; i++) {
                            System.out.println("听音乐:" + i);
                        }
                    }
                }.start();*/

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 1; i <= 50; i++) {
                            System.out.println("侃大山:" + i);
                        }
                    }
                });
                t.start();
            }
        }
    }
}
