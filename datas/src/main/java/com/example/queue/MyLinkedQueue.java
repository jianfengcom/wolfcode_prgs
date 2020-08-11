package com.example.queue;

import com.example.link.MyLinkedList;

import java.util.LinkedList;

public class MyLinkedQueue extends MyLinkedList {
    public boolean add(Object ele) { // offer
        return super.add(ele);
    }

    public Object poll() { // remove
        return super.removeLast();
    }

    public Object peek() { // element
        return super.getLast();
    }

    public static void main(String[] args) {
        // FIFO
        MyLinkedQueue queue = new MyLinkedQueue();
        queue.add("fuck");
        queue.add("hey");
        queue.add("biu");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
