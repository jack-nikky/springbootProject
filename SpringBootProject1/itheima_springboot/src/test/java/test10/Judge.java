package test10;

import java.util.Scanner;

public class Judge {
    public static void main(String[] args) {
        System.out.println("请输入一个数，如果这个数为2^n，则返回true");
        Scanner sc = new Scanner(System.in);
        int ss = sc.nextInt();
        System.out.println(judge(ss));
    }

    private static boolean judge(int ss) {
        int i=1;
        while(i<=ss){
            if(i==ss){
                return true;
            }
            i *= 2;
        }
        return  false;
    }
}
