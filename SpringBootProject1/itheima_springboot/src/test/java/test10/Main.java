package test10;
import  java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strMPN = str.split(",");
        int m,p,n;
        m = Integer.parseInt(strMPN[0]);
        p = Integer.parseInt(strMPN[1]);
        n = Integer.parseInt(strMPN[2]);

        int[][] A = new int[m][p];
        int[][] B = new int[p][n];
        int[][] C = new int[m][n];

        //A init
        for(int i=0;i<m;i++){
            str  = sc.nextLine();
            String[] strList = str.split(",");
            for(int j=0;j<p;j++){
                A[i][j] = Integer.parseInt(strList[j]);
            }
        }
        //B init
        for(int i=0;i<p;i++){
            str  = sc.nextLine();
            String[] strList = str.split(",");
            for(int j=0;j<n;j++){
                B[i][j] = Integer.parseInt(strList[j]);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                C[i][j] = mult(A,B,i,j,p);
                if(j==n-1){
                    System.out.print(C[i][j]);
                }else{
                    System.out.print(C[i][j]+",");
                }

            }
            System.out.println();
        }


    }

    private static int mult(int[][] A, int[][] B, int i, int j,int p) {
        int sum =0;
        for(int k=0;k<p;k++){
            sum += A[i][k]*B[k][j];
        }
        return  sum;
    }
}
