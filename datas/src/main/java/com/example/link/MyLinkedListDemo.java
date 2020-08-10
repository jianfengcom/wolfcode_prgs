package com.example.link;

public class MyLinkedListDemo {

    public static void main(String[] args) { // [fuck, hello]
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addLast("B");
        linkedList.addLast("C");
        linkedList.addLast("D");
        linkedList.addFirst("A");
        linkedList.addLast("E");
        System.out.println(linkedList);
        linkedList.addLast("D");
        linkedList.addLast("B");

        System.out.println(linkedList);
        linkedList.remove("D");
        System.out.println(linkedList);

        System.out.println(linkedList.size());
    }
}

