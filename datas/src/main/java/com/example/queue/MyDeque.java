package com.example.queue;

import com.example.array.MyArrayList;

import java.util.ArrayList;

public class MyDeque extends MyArrayList {

    public boolean addLast(Object ele) { // offer
        return super.add(ele);
    }
    public void addFirst(Object ele) {
        super.add(0, ele);
    }

    public Object pollLast() { // remove
        int last = super.size() - 1;
        return super.remove(last);
    }

    public Object pollFirst() {
        return super.remove(0);
    }

    public Object peekLast() { // element
        int last = super.size() - 1;
        return super.get(last);
    }
    public Object peekFirst() {
        return super.get(0);
    }

    public static void main(String[] args) {
        // FIFO
        MyDeque queue = new MyDeque();
        queue.addLast("fuck");
        queue.addFirst("hey");
        queue.addLast("biu");
        System.out.println(queue);
        System.out.println(queue.peekFirst());
        System.out.println(queue.peekLast());
        System.out.println(queue);
        System.out.println(queue.pollFirst());
        System.out.println(queue.pollLast());
        System.out.println(queue);
    }
}
