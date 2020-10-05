package test4;

import java.util.Arrays;

public class test3 {
    public static void main(String[] args) {
        longestValidParentheses("(()");

    }
    //A:硬币取值集合， M：最后的面值和
    public static int coinChange(int[] A , int M){
        int[] f = new int[M+1];
        int n = A.length;   //number of kinds of coins
        //初始化
        f[0] = 0;
        int i,j;
        for(i =1;i<=M;i++){
            f[i] = Integer.MAX_VALUE;
            for(j=0;j<n;j++){
                //考虑特殊情况
                if(i>=A[j]&&f[i-A[j]]!=Integer.MAX_VALUE){
                    //f[x]=min{  f[x-A[j]]+1........ }
                    f[i]=Math.min(f[i],f[i-A[j]]+1);
                }
            }
        }
        //处理不存在最优解的情况
        if(f[M]==Integer.MAX_VALUE){
            f[M]=-1;
        }
        return f[M];
    }
    public int uniquePaths(int m ,int n){
        int[][] f = new int[m][n];
        int i,j;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(i==0||j==0){
                    f[i][j]=1;
                }
                else {
                    f[i][j]=f[i-1][j]+f[i][j-1];
                }
            }
        }
        return f[m-1][n-1];
    }

    public static  Boolean conJump(int[] A){
        int n = A.length;

        //确定f 存什么
        boolean[] f = new boolean[n];
        //初始化
        f[0] = true;
        int i,j;
        for(j=1;j<n;++j){
            f[j] = false;
            for(i=0;i<j;++i){
                if(f[i]&& i+A[i]>=j){
                    f[j] = true;
                    break;
                }
            }
        }
        return f[n-1];
    }
    public static int longestValidParentheses (String s) {
        // write code here
        if(s==null){
        }
        String[] str = s.split("\\(\\)");
        System.out.println(str.length);

        int start=0,end=0,max=0;
        for(int i =0;i<str.length;i++){
            if(str[i].equals("")){
                end = i;
                max = Math.max(max,end-start+1);
            }else{
                start = i+1;
                end=end+1;
            }
        }
        return max;

    }

}
