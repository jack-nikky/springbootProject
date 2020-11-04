package CSDC;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        for(int i=0;i<n;i++){
            boolean flag = true;
            for(int j = i+1;j<n;j++){
                if(str.charAt(i)==str.charAt(j)) flag = false;
            }
            if(flag){
                System.out.println(str.charAt(i));
                break;
            }
        }
    }
}