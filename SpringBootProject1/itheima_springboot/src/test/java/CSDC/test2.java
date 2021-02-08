package CSDC;
import  java.util.*;
public class test2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length<k || nums.length==0||k==0) return new int[0];
        int[] res = new int[nums.length-k+1];
        Queue<Integer> queue = new PriorityQueue<>( new Comparator<Integer>(){
            @Override
            public int compare(Integer i1,Integer i2){
                return i2-i1;
            }
        });
        List<Integer> list = new ArrayList<>();
        for(int num:nums){
            list.add(Integer.valueOf(num));
        }


        for(int i=0;i<k;i++){
            queue.offer(list.get(i));
        }
        res[0] = queue.peek();
        int index = 1;
        for(int i=k;i<nums.length;i++){
            queue.remove(list.get(i-k));
            queue.offer(list.get(i));
            res[index++] = queue.peek();
        }
        return res;
    }


}
