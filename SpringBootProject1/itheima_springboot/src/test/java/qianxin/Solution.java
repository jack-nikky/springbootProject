package qianxin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        //map.put()//null 或者 value
        Queue<Integer> queue = new LinkedList();
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        int a = queue.remove();
        System.out.println(Arrays.toString(queue.toArray()));
    }


}
