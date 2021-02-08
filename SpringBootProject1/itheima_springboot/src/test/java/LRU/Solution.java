package LRU;
import java.util.*;
public class Solution {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        // write code here
        int len = (int) Arrays.stream(operators).filter(operator -> operator[0] == 2).count();
        int[] ret = new int[len];
        LRUCache lruCache = new LRUCache(k);
        int index = 0;
        for (int[] operator : operators) {
            if (operator[0] == 1) {
                lruCache.set(operator[1], operator[2]);
            } else {
                ret[index] = lruCache.get(operator[1]);
                index++;
            }
        }
        return ret;
    }

    /**
    * node 类
    * @key 键
    * @value 值
    * @pre 上一个节点
    * @next 下一个节点
    */
    final class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key,int value){
            this.key  =key;
            this.value = value;
        }
    }

    final class LRUCache{
        final Map<Integer,Node> cacheMap;
        final int capacity;
        Node head = new Node(-1,-1);
        Node tail = new Node(-1,-1);

        LRUCache(int capacity) {
            this.capacity = capacity;
            this.cacheMap = new HashMap<>(capacity);
            head.next = tail;
            tail.pre = head;
        }

        //将一个节点放在尾部
        public void totail(Node node){
            //填充属性
            node.pre = tail.pre;
            node.next = tail;
            //插入
            tail.pre.next = node;
            tail.pre = node;
        }
        public int get(int key){
            if(!cacheMap.containsKey(key)){
                return -1;
            }
            //将当前节点从map中移除
            Node node = cacheMap.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;

            //将当前节点移动到尾部
            totail(node);
            return node.value;
        }
        public void set(int key,int value){
            //通过get（-1）判断是否存在key, 如果存在，get的时候也会将其移动到尾部
            if(get(key)!=-1) {
                cacheMap.get(key).value = value;
            }else{
                //判断是否需要移除节点
                if(cacheMap.size() == capacity){
                    int val = head.next.key;
                    head.next.next.pre = head;
                    head.next = head.next.next;
                    cacheMap.remove(val);
                }
                Node node = new Node(key,value);
                cacheMap.put(key,node);
                totail(node);
            }
        }
    }
}