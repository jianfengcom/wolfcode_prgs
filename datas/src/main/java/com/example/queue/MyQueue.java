package com.example.queue;

import com.example.array.MyArrayList;

public class MyQueue extends MyArrayList {

    public boolean add(Object ele) { // offer
        return super.add(ele);
    }

    public Object poll() { // remove
        int last = super.size() - 1;
        return super.remove(last);
    }

    public Object peek() { // element
        int last = super.size() - 1;
        return super.get(last);
    }

    public static void main(String[] args) {
        // FIFO
        MyQueue queue = new MyQueue();
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
