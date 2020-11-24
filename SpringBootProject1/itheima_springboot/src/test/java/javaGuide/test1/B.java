package javaGuide.test1;

import java.util.Arrays;

public class B{
    public static void main(String[] args) {
        String str = "a";
        String[] strlist =  str.split("a");
        int n = strlist.length;
        System.out.println(n);
        System.out.println(Arrays.toString(strlist));
    }

}
