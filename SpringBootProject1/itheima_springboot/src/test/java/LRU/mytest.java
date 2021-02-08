package LRU;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class mytest {
    public int[] LRU(int[][] operators, int k) {
        int len = 0;
        for(int i = 0;i<operators.length;i++){
            if(operators[i][0]==2) len++;
        }
        int[] ret = new int[len];
        LRUCache lruCache = new LRUCache(k);
        int index = 0;
        for(int[] operator : operators){
            if(operator[0]==1){
                lruCache.set(operator[1],operator[2]);
            }else if(operator[0]==2){
                ret[index] = lruCache.get(operator[1]);
                index++;
            }
        }
        return ret;
    }
    final class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    final class LRUCache{
        final Map<Integer,Node> cacheMap;
        final int capacity;
        Node head = new Node(-1,-1);//头结点
        Node tail = new Node(-1,-1);//尾结点

        public LRUCache(int capacity){
            this.capacity = capacity;
            this.cacheMap = new HashMap<>(capacity);
            head.next = tail;
            tail.pre = head;
        }
        public void toTail(Node node){
            node.next = tail;
            node.pre = tail.pre;
            tail.pre.next = node;
            tail.pre = node;
        }
        public int get(int key){
            if(cacheMap.containsKey(key)){
                Node node = cacheMap.get(key);
                node.pre.next = node.next;
                node.next.pre = node.pre;


                toTail(node);
                return node.value;
            }
            return -1;
        }
        public void set(int key,int value){
            if(get(key)!=-1){
                cacheMap.get(key).value = value;
            }else {
                if(capacity==cacheMap.size()){

                    int val = head.next.key;
                    head.next.next.pre = head;
                    head.next = head.next.next;
                    cacheMap.remove(val);
                }
                Node node = new Node(key,value);
                cacheMap.put(key,node);
                toTail(node);
            }

        }
    }
}
