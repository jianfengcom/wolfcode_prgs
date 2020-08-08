package com.example.day01._03_thread;

/**
 * 线程的两种创建方式
 */

class MusicThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("听音乐:" + i);
        }
    }
}

class ChatRunnableImpl implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("侃大山:" + i);
        }
    }
}

public class BuildDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            System.out.println("打游戏:" + i);
            if (i == 10) {
                //new MusicThread().start();
                ChatRunnableImpl runnable = new ChatRunnableImpl();
                new Thread(runnable).start();
            }
        }
    }
}
