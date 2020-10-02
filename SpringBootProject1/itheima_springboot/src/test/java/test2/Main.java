package test2;


import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int m = sc.nextInt();  //用户数，行数
        int n = sc.nextInt();  //产品数，列数
        sc.nextLine();
        String[] strList = new String[m];
        for(int i =0;i<m;i++ ){
            strList[i] = sc.nextLine();
        }
        String[] string = new String[n];
        for(int i=0;i<string.length;i++){
            string[i]="";
        }
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                string[j]+=strList[i].charAt(j);
            }
        }
        TreeSet<String> ts = new TreeSet<>();
        for(int i=0;i<n;i++){
            ts.add(string[i]);
        }
        System.out.println(ts.size());
    }
}

