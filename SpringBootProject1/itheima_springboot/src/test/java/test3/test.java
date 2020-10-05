package test3;

import java.util.HashSet;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>() ;
        set.add(2);
        set.add(5);
        set.add(1);
        set.add(0);
        set.add(500);
        System.out.println(set);
    }
}
