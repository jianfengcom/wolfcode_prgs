package com.example.expand;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池之 ThreadPoolExecutor 的使用
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        int corePoolSize = 2;
        int maximumPoolSize = 4;
        long keepAliveTime = 10L;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ThreadFactory threadFactory = new MyThreadFactory();
        RejectedExecutionHandler handler = new MyPolicy();

        // 线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler);

        // 启动所有核心线程，使其处于等待工作的空闲状态
        int count = executor.prestartAllCoreThreads();
        System.out.println(count);
        //executor.prestartCoreThread();

        for (int i = 0; i < 12; i++) {
            executor.execute(new MyTask(String.valueOf(i)));
        }
        executor.shutdown();
    }
}

class MyThreadFactory implements ThreadFactory {
    private AtomicInteger THREAD_NUM = new AtomicInteger();

    @Override
    public Thread newThread(Runnable r) {
        // 记录线程被创建的日志
        Thread t = new Thread(r, "my_thread_" + THREAD_NUM.incrementAndGet());
        System.out.println(t.getName() + " is created!");
        return t;
    }
}

class MyPolicy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString() + " is rejected!");
    }
}

class MyTask implements Runnable {
    private String name;

    public MyTask(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyTask[name=" + name + "]";
    }

    @Override
    public void run() {
        System.out.println(this.toString() + " is running");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


