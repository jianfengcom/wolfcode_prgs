package com.example.queue;

import com.example.link.MyLinkedList;

import java.util.LinkedList;

public class MyLinkedDeque extends MyLinkedList {
    public void addLast(Object ele) { // offer
        super.addLast(ele);
    }

    public void addFirst(Object ele) {
        super.addFirst(ele);
    }

    public Object pollLast() { // remove
        return super.removeLast();
    }

    public Object pollFirst() {
        return super.removeFirst();
    }

    public Object peekLast() { // element
        return super.getLast();
    }

    public Object peekFirst() {
        return super.getFirst();
    }

    public static void main(String[] args) {
        // FIFO
        MyLinkedDeque queue = new MyLinkedDeque();
        queue.addFirst("fuck");
        queue.addFirst("hey");
        queue.addFirst("biu");
        System.out.println(queue);
        System.out.println(queue.peekFirst());
        System.out.println(queue.peekLast());
        System.out.println(queue);
        System.out.println(queue.pollFirst());
        System.out.println(queue.pollLast());
        System.out.println(queue);
    }

    public Object peek() {
        return peekFirst();
    }
    public Object poll() {
        return peekFirst();
    }
}
