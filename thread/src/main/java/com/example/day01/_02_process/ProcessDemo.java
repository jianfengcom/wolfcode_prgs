package com.example.day01._02_process;

import java.io.IOException;

/**
 * 创建进程的两种方式
 */
public class ProcessDemo {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("notepad");

        ProcessBuilder builder = new ProcessBuilder("notepad");
        //builder.command("notepad");
        builder.start();
    }
}
