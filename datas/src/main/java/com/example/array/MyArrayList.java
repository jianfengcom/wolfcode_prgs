package com.example.array;

import java.util.Arrays;

public class MyArrayList {
    private Object[] elements; 
    private int size;

    final private int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("初始化容量不能小于0");
        }
        elements = new Object[initialCapacity];
    }

    public void add(Object ele) {
        if (ele == null) {
            return;
        }
        if (size == elements.length) {
            // 扩容
            elements = Arrays.copyOf(elements, size * 2 + 1);
        }
        elements[size] = ele;
        size++;
    }

    public Object get(int index) {
        if (index < 0 || index > elements.length - 1) {
            throw new IllegalArgumentException("参数越界");
        }
        return elements[index];
    }

    public Object remove(int index) {
        if (index == size - 1) {
            Object temp = elements[index];
            elements[index] = null;
            size--;
            return temp;
        }

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
            if (i == size - 2) {
                Object temp = elements[i + 1];
                elements[i + 1] = null;
                size--;
                return temp;
            }
        }
        return null;
    }

    public Object set(int index, Object newNum) {
        Object oldNum = get(index);
        elements[index] = newNum;
        return oldNum;
    }

    public String toString() {
        if (elements == null) {
            return "null";
        }
        if (size == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder(size * 2 + 1);
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(elements[i]);
            if (i == size - 1) {
                builder.append("]");
            } else {
                builder.append(",");
            }
        }
        return builder.toString();
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
