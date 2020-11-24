package javaGuide.test3;

import java.util.Arrays;
import java.util.Random;

public class test {
    public static void main(String[] args){

        for(int i=0;i<10;++i){
            int n = new Random().nextInt(2);
            System.out.println(n);
        }


    }

    public static Object getObject(){
        Object o = new Object();
        System.out.println("函数中定义的变量："+o);
        return o;
    }
}
