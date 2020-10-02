package test;

import java.util.LinkedList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        System.out.println("请输入数组，用空格隔开： ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("最小操作次数为："+souletion(s));
    }

    private static int souletion(String s) {
        String[] ss = s.split(" ");
        LinkedList<Integer> al = new LinkedList<>();
        for(String i:ss){
            al.add(Integer.parseInt(i));
        }
        int max,count=0;
        while (al.size()>1){
            max = 0;
            for(int i = 0;i<al.size();i++){
                if(al.get(i)>al.get(max)){
                    max = i;
                }
            }
            if(max!=al.size()-1){
                al.remove(max);
                count++;
            }else {
                al.removeLast();
            }
        }
        return count;
    }
}
