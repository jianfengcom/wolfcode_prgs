package com.example.array;

import java.util.Arrays;

public class MyArrayList {
    private Object[] elements; 
    private int size;

    final static private int DEFAULT_CAPACITY = 10;
    final static private Object[] DEFAULT_EMPTY_LIST = {};

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity == 0) {
            elements = DEFAULT_EMPTY_LIST;
        } else if (initialCapacity > 0) {
            elements = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("初始化容量不能小于0");
        }
    }

    public boolean add(Object ele) {
        ensureCapacity(size + 1);
        elements[size++] = ele;
        return true;
    }

    public void add(int index, Object ele) {
        rangeCheck(index);
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = ele;
        size++;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = minCapacity + (minCapacity >> 1);
            if (newCapacity > MAX_ARRAY_SIZE) {
                newCapacity = newCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public Object get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    public Object remove(int index) {
        rangeCheck(index);
        Object oldEle = elements[index];
        if (index == size - 1) {
            elements[size--] = null;
        } else {
            System.arraycopy(elements, index + 1, elements, index, size - index);
            elements[size--] = null;
        }
        return oldEle;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("参数越界");
        }
    }

    public Object set(int index, Object newEle) {
        rangeCheck(index);
        Object oldEle = elements[index];
        elements[index] = newEle;
        return oldEle;
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

    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}
