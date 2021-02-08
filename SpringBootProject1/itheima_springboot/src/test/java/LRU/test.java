package LRU;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test {
//     public static void main(String[] args) {
//         int[][] operators = {{1, 2, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
//         Solution solution = new Solution();
//         int[] ints = solution.LRU(operators, 3);
//         System.out.println(Arrays.toString(ints));
//     }

    public int[] LRU(int[][] operators, int k) {
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
     * 注：头节点与尾节点为哨兵节点不容修改，注释中的头节点为头部第二个节点，尾节点为尾部倒二节点
     */
    final class LRUCache {

        final Map<Integer, Node> cacheMap;
        final int capacity;
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cacheMap = new HashMap<>(capacity);
            head.next = tail;
            tail.pre = head;
        }

        public void set(int key, int value) {
            // get(): 判断是否存在，如果存在将节点放到头部
            if (get(key) != -1) {
                cacheMap.get(key).value = value;
            } else {
                // 更新第三个节点头部信息，将第二个节点信息替换为第三个节点 => 相当于删除第二个节点，也就是头部节点
                if (cacheMap.size() == capacity) {
                    int headKey = head.next.key;
                    head.next.next.pre = head;
                    head.next = head.next.next;
                    cacheMap.remove(headKey);
                }
                Node node = new Node(key, value);
                cacheMap.put(key, node);
                toTail(node);
            }
        }

        public int get(int key) {
            if (cacheMap.containsKey(key)) {
                // 将当前节点取出
                Node node = cacheMap.get(key);
                node.pre.next = node.next;
                node.next.pre = node.pre;
                // 将取出的节点放到尾部
                toTail(node);
                return node.value;
            }
            return -1;
        }

        /**
         * 将当前节点放置到尾部
         *
         * @param node 新节点
         */
        public void toTail(Node node) {
            // ｜head｜tail｜
            // ｜head｜node｜tail｜ -- 从后插入新节点
            // 填充新节点属性数据
            node.pre = tail.pre;
            node.next = tail;
            // 将新节点挂到双向列表尾部
            tail.pre.next = node;
            tail.pre = node;
        }
    }

    final class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
