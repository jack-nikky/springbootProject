package test8;

import java.util.ArrayList;

public class test2 {
    public static void main(String[] args) {
        ArrayList al =new ArrayList();
        Object[] objects = al.toArray();
        al.add(2);
        al.add("sss");
        System.out.println(al);
    }

}
