package com.example.array;

public class BasketballPlayerDemo {
    public static void main(String[] args) {
        // 1.初始化容量
        PlayerList.init(0);
        // 2.添加球衣号码
        PlayerList.add(11);
        PlayerList.add(22);
        PlayerList.add(33);
        PlayerList.add(44);
        PlayerList.add(55);
        PlayerList.print();
        // 3.获取指定位置的球衣号码
        System.out.println(PlayerList.get(2));
        // 4.获取指定球衣号码的位置
        System.out.println(PlayerList.getIndexByPlayNum(33));
        // 5.设置指定位置的球衣号码
        System.out.println(PlayerList.set(2, 2333));
        PlayerList.print();
        // 6.替换球衣号码 8 => 24
        PlayerList.update(22, 2);
        PlayerList.print();
        // 7.删除
        PlayerList.delete(4);
        PlayerList.delete(4);
        PlayerList.print();
        System.out.println(PlayerList.getSize());
        PlayerList.delete(3);
        PlayerList.print();
        System.out.println(PlayerList.getSize());
        // 8.打印
    }
}
