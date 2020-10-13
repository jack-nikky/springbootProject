package test8;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        String s1 = "xiaopeng" ;
        String s2 = "xiaopeng" ;
        String[] strList = {"assd","cdscd"};

        System.out.println(strList[1]);
        change(strList);
        System.out.println(strList[1]);


    }
    //引用的地址传值，数组
    //String由于其不可变性，值变了，
    public static void change(String[] str){
        str[1] ="cdcsdv";
    }


}
