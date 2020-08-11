package com.example.link;

import java.util.NoSuchElementException;

public class MyLinkedList {
    private Node first;
    private Node last;
    private int size;

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder(size * 2 + 1);
        builder.append("[");

        // old
        /*builder.append(first.ele);
        Node temp = first;
        for (;;) {
            temp = temp.next;
            if (temp != null) {
                builder.append(",");
                builder.append(temp.ele);
            } else {
                builder.append("]");
                break;
            }
        }*/

        // new
        for (Node item = first; item != null; item = item.next) {
            builder.append(item.ele);
            if (item.next != null) {
                builder.append(",");
            } else {
                builder.append("]");
            }
        }
        return builder.toString();
    }

    public int size() {
        return size;
    }

    private static class Node {
        Node prev;
        Node next;
        Object ele;

        Node(Node prev, Object ele, Node next) {
            this.prev = prev;
            this.next = next;
            this.ele = ele;
        }
    }

    public boolean add(Object ele) {
        addLast(ele);
        return true;
    }

    public void addLast(Object ele) {
        final Node l = last;
        final Node node = new Node(l, ele, null);
        if (l == null) {
            first = node;
        } else {
            l.next = node;
        }
        last = node;
        size++;
    }

    public void addFirst(Object ele) {
        final Node f = first;
        final Node node = new Node(null, ele, f);
        if (f == null) {
            last = node;
        } else {
            f.prev = node;
        }
        first = node;
        size++;
    }

    /**
     * todo
     * 删除所有匹配的链点 (旧)
     *
     * @param ele
     */
    public void removeOld(Object ele) {
        Node temp = this.first;
        for (int i = 0; i < size; i++) {
            if (temp.ele.equals(ele)) {
                // 处理前面
                if (temp.prev == null) { // 头
                    temp.next.prev = null;
                    first = temp.next;
                    temp.next = null;
                    temp = first;
                    continue;
                }
                // 处理后面
                if (temp.next == null) { // 头
                    temp.prev.next = null;
                    last = temp.prev;
                    temp.prev = null;
                    temp = null;
                    break;
                }
                // 中间
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                temp = temp.next;
                size--;
            } else {
                temp = temp.next;
            }
        }
    }

    /**
     * 删除匹配的第一个链点
     * Removes the first occurrence of the specified element from this list
     * @param ele
     * @return
     */
    public boolean remove(Object ele) {
        if (ele == null) {
            for (Node item = first; item != null; item = item.next) {
                if (item.ele == null) {
                    unLink(item);
                    return true;
                }
            }
        } else {
            for (Node item = first; item != null; item = item.next) {
                if (ele.equals(item.ele)) { // item.ele 可能为null
                    unLink(item);
                    return true;
                }
            }
        }
        return false;
    }

    public Object removeFirst() {
        final Node f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return unLink(f);
    }

    public Object removeLast() {
        final Node l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return unLink(l);
    }

    private Object unLink(Node item) { // 断联
        final Object element = item.ele;
        final Node prev = item.prev;
        final Node next = item.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            item.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            item.next = null;
        }
        item.ele = null;
        size--;
        return element;
    }

    public Object getLast() {
        final Node l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.ele;
    }

    public Object getFirst() {
        final Node f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return f.ele;
    }
}
