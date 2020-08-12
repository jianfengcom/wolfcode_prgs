package com.example.array;

import java.util.*;

public class MyArrays {

    // 1.对象 2.范围方法
    public static <T> List<T> asList(T... elements) {
        System.out.println(elements); //[Ljava.lang.Integer;@27c170f0 什么都不传 等价于 []:
        /* old
        ArrayList<T> list = new ArrayList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;*/

        ArrayList<T> list = new ArrayList<>(elements);
        System.out.println(list.size());
        return list;
    }

    private static class ArrayList<E> extends AbstractList<E>
            implements RandomAccess, java.io.Serializable {
        private final E[] a;

        ArrayList(E[] array) {
            a = Objects.requireNonNull(array);
        }

        @Override
        public E get(int index) {
            return a[index];
        }

        @Override
        public int size() {
            return a.length;
        }
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("fuck", "hey", "love");
        System.out.println(strings);

        System.out.println();
        List<Integer> integers = MyArrays.asList(9, 5, 2, 7);
        System.out.println(integers);
    }
}
