package javaGuide.test3;

public class Sort {
    public void swap(int[] a,int start,int end){
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }
    public int partition(int[] a,int start,int end){
        //以start为基准数
        //用来存放下一个比基准数小的索引
        int index = start+1;
        for(int i=index;i<=end;i++){
            if(a[start]>a[i]){
                swap(a,index++,i);
            }
        }
        //现在index指向的必定大于基准值
        index--;
        swap(a,index,start);
        return index;
    }
    public void quickSort(int[] a,int start,int end){
        if(start<end){
            int partition = partition(a,start,end);
            quickSort(a,start,partition-1);
            quickSort(a,partition+1,end);
        }
    }
}
