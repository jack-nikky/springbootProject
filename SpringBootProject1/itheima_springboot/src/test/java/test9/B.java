package test9;

import java.util.ArrayList;
import java.util.Arrays;

public class B {

    public int a = 1;
    public static void main(String[] args) {
        char[] sss = new char[]{'a','b','c',' ','c','c','c'};

        change(sss);

    }
    class a{

    }

    private static void change(char[] sss) {
        System.out.println(sss);
        String str = String.valueOf(sss);
        String[] s = str.split(" ");

    }
}


