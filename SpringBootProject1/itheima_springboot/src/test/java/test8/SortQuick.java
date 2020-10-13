package test8;

import java.util.Arrays;

public class SortQuick {
    public void swap(int[] a, int i,int j){
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public int partition(int[] a,int start,int end){
        //设置基准值的索引
        int pivot = start;
        //记录下一个放比基准值小的值的索引
        int index = start+1;
        //遍历，找到比基准值小的，依次放在基准值后
        for(int i=index;i<end;i++){
            if(a[i]<a[pivot]){
                swap(a,i,index);
                index ++;
            }
        }
        //由于此时index位置的值必然大于等于基准值，所以把基准值和index-1位置的值互换，这样一来就拍好序了
        swap(a,pivot,index-1);
        //返回的也是基准值的索引
        return index-1;
    }
    public int[] quicksort(int[] arr, int start,int end){
        if(start<end){
            int partition = partition(arr, start, end);
            quicksort(arr,start,partition-1);
            quicksort(arr,partition+1,end);
        }
        return arr;
    }

}
