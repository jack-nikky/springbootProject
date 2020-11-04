package test12;

import java.util.Arrays;
import java.util.Comparator;

class test3 {
    public static void main(String[] args) {
        int[][] f = new int[][]{{5,4},{6,4},{6,7},{2,3}};
        //maxEnvelopes(f);
        int[] m = new int[]{2,1};
        System.out.println(lengthofLLIS(m));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0]!=b[0] ? a[0]-b[0] : b[1]-a[1];
            }
        });
        int[] f = new int[n];
        for(int i=0;i<n;i++){
            f[i] = envelopes[i][1];
        }
        return lengthofLLIS(f);
    }

    public static int lengthofLLIS(int[] nums){
        int[] tails = new int[nums.length];
        //表示tails中我们所取的长度
        int len = 0;
        for(int num : nums) {
            //[start,end]表示tails数组已经排好序的范围
            int start = 0, end = len;
            //二分查找，
            while(start < end) {
                int m = (start + end) / 2;
                if(tails[m] < num) start = m + 1;
                else end = m;
            }

            tails[start] = num;
            //什么时候len不等end
            if(len == end) len++;
        }
        return len;
    }

}
