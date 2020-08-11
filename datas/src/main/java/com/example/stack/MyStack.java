package com.example.stack;

import com.example.array.MyArrayList;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyStack extends ArrayList {
    public Object push(Object ele) {
        super.add(ele);
        return ele;
    }

    public Object pop() {
        if (super.size() == 0) {
            throw new NoSuchElementException("空栈!");
        }
        int index = super.size() - 1;
        return super.remove(index);
    }

    public Object peek() {
        if (super.size() == 0) {
            throw new NoSuchElementException("空栈!");
        }
        int index = super.size() - 1;
        return super.get(index);
    }

    public boolean empty() {
        super.clear();
        return true;
    }

    public int search(Object ele) {
        return super.indexOf(ele);
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push("fuck");
        stack.push("hey");
        stack.push("peace");
        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println();

        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println(stack.search("peace"));
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println();

        stack.clear();
        System.out.println(stack.toString());
        System.out.println(stack.size());
        System.out.println(stack.search("peace"));
    }
}
