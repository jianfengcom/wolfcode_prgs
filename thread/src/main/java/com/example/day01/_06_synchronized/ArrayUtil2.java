package com.example.day01._06_synchronized;

/**
 * 单例模式 - 懒加载式
 */
public class ArrayUtil2 {
    // 被volatile修饰的变量的值，将不会被本地线程缓存，所有对该变量的读写都是直接操作共享内存
    // volatile关键字可能会屏蔽掉虚拟机中一些必要的代码优化，运行效率不高
    volatile private static ArrayUtil2 instance;

    private ArrayUtil2() {
    }

    /*synchronized public static ArrayUtil2 getInstance() {
        if (instance == null) {
            instance = new ArrayUtil2();
        }
        return instance;
    }*/

    /*public static ArrayUtil2 getInstance() { // 等价于第一种
        synchronized (ArrayUtil2.class) {
            if (instance == null) {
                instance = new ArrayUtil2();
            }
        }
        return instance;
    }*/

    public static ArrayUtil2 getInstance() { // 等价于第一种
        if (instance == null) {
            synchronized (ArrayUtil2.class) {
                if (instance == null) {
                    instance = new ArrayUtil2();
                }
            }
        }
        return instance;
    }
}
