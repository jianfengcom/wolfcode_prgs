package com.example.link;

public class MyLinkedList {
    private Node first;
    private Node last;
    private int size;

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder(size * 2 + 1);
        builder.append("[");
        builder.append(first.ele);
        Node temp = first;
        for (; ; ) {
            temp = temp.next;
            if (temp != null) {
                builder.append(",");
                builder.append(temp.ele);
            } else {
                builder.append("]");
                break;
            }
        }
        return builder.toString();
    }

    public int size() {
        return size;
    }

    class Node {
        private Node prev;
        private Node next;
        protected Object ele;

        private Node(Object ele) {
            this.ele = ele;
        }
    }

    public void addLast(Object ele) {
        Node node = new Node(ele);
        if (size == 0) {
            first = node;
            last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
        size++;
    }

    public void addFirst(Object ele) {
        Node node = new Node(ele);
        if (size == 0) {
            first = node;
            last = node;
        } else {
            this.first.prev = node;
            node.next = this.first;
            this.first = node;
        }
        size++;
    }

    /**
     * 删除所有匹配的链点
     *
     * @param ele
     */
    public void remove(Object ele) {
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
}
