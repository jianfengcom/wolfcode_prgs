package com.example.array;

public class BasketBallerDemo {
    private static Integer[] players;
    private static int size;

    public static void main(String[] args) {
        // 1.初始化容量
        init(5);
        // 2.添加球衣号码
        add(11);
        add(22);
        add(33);
        add(44);
        add(55);
        print();
        // 3.获取指定位置的球衣号码
        System.out.println(get(2));
        // 4.获取指定球衣号码的位置
        System.out.println(getIndexByPlayNum(33));
        // 5.设置指定位置的球衣号码
        System.out.println(set(2, 2333));
        print();
        // 6.替换球衣号码 8 => 24
        update(22, 2);
        print();
        // 7.删除
        delete(4);
        delete(4);
        print();
        System.out.println(size);
        delete(3);
        print();
        System.out.println(size);
        // 8.打印
    }

    private static Integer delete(int index) { // 0 len-1
        if (index == size - 1) {
            Integer temp = players[index];
            players[index] = null;
            size--;
            return temp;
        }

        for (int i = index; i < size - 1; i++) {
            players[i] = players[i + 1];
            if (i == size - 2) {
                Integer temp = players[i + 1];
                players[i + 1] = null;
                size--;
                return temp;
            }
        }
        return null;
    }

    private static void update(Integer source, Integer target) {
        int index = getIndexByPlayNum(source);
        players[index] = target;
    }

    private static Integer set(int index, Integer newNum) {
        Integer oldNum = get(index);
        players[index] = newNum;
        return oldNum;
    }

    private static int getIndexByPlayNum(Integer playNum) {
        for (int i = 0; i < size; i++) {
            if (players[i].equals(playNum)) {
                return i;
            }
        }
        return - 1;
    }

    private static String print() {
        StringBuilder builder = new StringBuilder(players.length * 2 + 1);
        builder.append("[");
        for (int i = 0; i < players.length; i++) {
            builder.append(players[i]);
            if (i == players.length - 1) {
                builder.append("]");
            } else {
                builder.append(",");
            }
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    private static Integer get(int index) {
        return players[index];
    }

    public static void add(Integer playNum) {
        players[size] = playNum;
        size++;
    }

    public static void init(int initialCapacity) {
        players = new Integer[initialCapacity];
    }
}