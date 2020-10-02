package test;

import java.util.Arrays;

public class test5 {
    public static void main(String[] args) {
        String[] s = new String[5];
        System.out.println(Arrays.toString(s));

        int[] a = new int[]{3,1,2,5,4};
        System.out.println(Arrays.toString(a));
        //Arrays.sort(a);
        //System.out.println(Arrays.toString(a));
        int i = Arrays.hashCode(a);
        System.out.println(i);


    }
}
