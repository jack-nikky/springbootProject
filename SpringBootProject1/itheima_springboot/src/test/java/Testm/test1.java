package Testm;

import java.util.*;

public class test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int start = 0;
        int end = 0;
        boolean flag = false;
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='M'){
                flag = true;
            }else if(flag){
                if(str.charAt(i)=='T'){
                    start = i+1;
                    break;
                }
            }
        }

        flag = false;
        for(int i=n-1;i>=0;i--){
            if(str.charAt(i)=='T'){
                flag = true;
            }else if(flag){
                if(str.charAt(i)=='M'){
                    end = i-1;
                    break;
                }
            }
        }
        System.out.println(str.substring(start,end+1));

    }


}
