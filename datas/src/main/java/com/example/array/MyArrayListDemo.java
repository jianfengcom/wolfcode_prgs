package com.example.array;

public class MyArrayListDemo {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(0);
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}
