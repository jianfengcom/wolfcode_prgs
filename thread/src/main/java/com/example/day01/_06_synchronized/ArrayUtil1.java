package com.example.day01._06_synchronized;

/**
 * 单例模式 - 饿汉式 (简单、粗暴、安全)
 */
public class ArrayUtil1 {
    private static ArrayUtil1 instance = new ArrayUtil1();

    private ArrayUtil1() {

    }

    public static ArrayUtil1 getInstance() {
        return instance;
    }

    public void doWork() {}
}
