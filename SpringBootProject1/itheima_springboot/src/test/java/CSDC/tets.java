package CSDC;

import java.util.Arrays;

public class tets {
    public void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public int partition(int[] arr,int start,int end){
        //基准值 start
        int index = start+1;
        for(int i=index;i<=end;i++){
            if(arr[start]>arr[i]){
                swap(arr,index++,i);
            }
        }
        swap(arr,--index,start);
        return index;
    }

    public  void quickSort(int[] arr,int start,int end){
        if(start<end){
            int partition = partition(arr,start,end);
            quickSort(arr,start,partition-1);
            quickSort(arr,partition+1,end);
        }
    }
}
class te{
    public static void main(String[] args) {
        int [] a = new int[]{3,2,5,4,6};
        tets m = new tets();
        m.quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
