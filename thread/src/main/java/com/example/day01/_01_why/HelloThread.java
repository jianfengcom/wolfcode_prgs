package com.example.day01._01_why;

public class HelloThread {
    public static void main(String[] args) {
        System.out.println("start ...");
        playMusic();
        playGame();
        System.out.println("end 。");
    }

    private static void playMusic() {
        for (int i = 0; i < 50; i++) {
            System.out.println("听音乐:" + i);
        }
    }
    private static void playGame() {
        for (int i = 0; i < 50; i++) {
            System.out.println("玩游戏:" + i);
        }
    }
}
