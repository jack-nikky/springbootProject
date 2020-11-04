package CSDC;

import java.util.*;
public class min {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = 1;
        long m = 1;
        while(m % n != 0){
            m = m*10 +1;
            len++;
        }
        System.out.print(len);
    }
}