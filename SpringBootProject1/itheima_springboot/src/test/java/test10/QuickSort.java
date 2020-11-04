package test10;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a= {1,6,5,5,2,11,33,22,56};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    //交换函数
    public static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //对数组进行比较，小于基准值的在左边，  大于的在右边
    //返回的基准值排外序后的索引
    public static int partition(int[] a, int start, int end){
        int base=start; // 基准值的索引
        int index = base +1;  //游标，用来记录下一个该放置比a[base] 小的数

        for(int i=index;i<=end;i++){
            //比基准值小， 交换
            if(a[i]<a[base]){
                swap(a,i,index);
                //游标更新
                index++;
            }
        }
        //上面的做完了，还没完，此时base应该放在index的位置， 但由于现在index的数一定比base位置的数大， 我们选择交换index-1
        swap(a,index-1,base);
        return index-1; //返回的基准值的索引
    }
    //递归比较
    public static int[] quickSort(int[] a, int start,int end){
        if(start<end){
            int partition = partition(a,start,end );
            quickSort(a,start,partition-1);
            quickSort(a,partition+1,end);
        }
        return a;
    }
}
