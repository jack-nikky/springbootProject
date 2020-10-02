package test;

import java.util.LinkedList;

public class test2 {
    public static void main(String[] args) {
        LinkedList<Integer> lk = new LinkedList<>();
        lk.add(2);
        lk.add(3);
        lk.add(5);
        System.out.println("原来的linkedlist="+lk);
        lk.remove(0);
        System.out.println("romove的linkedlist="+lk);
        Integer s = new Integer(5);
        lk.remove(s);
        System.out.println("romove后的linkedlist="+lk);


    }
}
