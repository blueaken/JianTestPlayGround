package lintcode.design;

import java.util.HashMap;
import java.util.LinkedList;

public class LFUCache_LE_460_P1 {
    /*
    - 146 LRU Cache的进阶，代码会比较多，因为需要实现O(1)时间, 未必会直接考，但可能会问如何实现。结合花花的视频，可以用HashMap + Doubly LinkedList实现，或者HashMap + Balanced Binary Tree, 但这种情况时间会是O(log capacity)
    - ref https://zxi.mytechroad.com/blog/hashtable/leetcode-460-lfu-cache/
    - 146用了自己实现的Doubly LinkedList, 这里参考花花的讲解用LinkedList
    ================================
    4.28.23 - ref东哥模板和previous solution，用自己的Node类 + LinkedList来实现
    ================================
    */

    class Node {
        int key, val, freq;

        Node(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }

    int capacity, minFreq;
    HashMap<Integer, Node> nodeMap = new HashMap<>(); // key, node
    HashMap<Integer, LinkedList<Integer>> freqToKeys = new HashMap<>(); // freq, list of node keys

    public LFUCache_LE_460_P1(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
        Node cur = nodeMap.get(key);
        increaseFreq(cur);
        return cur.val;
    }

    void increaseFreq(Node node) {
        // update the node's freq in the nodeMap
        int freq = node.freq;
        if (!freqToKeys.containsKey(freq) || freqToKeys.get(freq).isEmpty()) {
            return;
        }

        nodeMap.get(node.key).freq++;

        // remove the key from previous freq's key list
        freqToKeys.get(freq).remove(Integer.valueOf(node.key));

        // clean up if freq list empty
        if (freqToKeys.get(freq).size() == 0) {
            freqToKeys.remove(freq);
            // update minFreq if necessary
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }

        // insert the node key to the new freq's list
        freqToKeys.putIfAbsent(freq+1, new LinkedList<>());
        freqToKeys.get(freq+1).addFirst(node.key);
    }

    public void put(int key, int value) {
        if (this.capacity == 0) {
            return;
        }

        if (nodeMap.containsKey(key)) {
            nodeMap.get(key).val = value;
            Node cur = nodeMap.get(key);
            increaseFreq(cur);
            return;
        }

        if (this.capacity == nodeMap.size()) {
            removeMinFreqNode();
        }

        // new node's freq is always 1
        nodeMap.put(key, new Node(key, value, 1));
        this.minFreq = 1;
        freqToKeys.putIfAbsent(1, new LinkedList<>());
        freqToKeys.get(1).addFirst(key);

        return;
    }

    void removeMinFreqNode() {
        int keyToDel = freqToKeys.get(minFreq).pollLast();
        // clean up if min freq list empty
        if (freqToKeys.get(minFreq).size() == 0) {
            freqToKeys.remove(minFreq);
            this.minFreq++;
        }

        nodeMap.remove(keyToDel);
        return;
    }

    public static void main(String[] args) {
        LFUCache_LE_460_P1 solution = new LFUCache_LE_460_P1(3);
        solution.put(1, 1);
        solution.put(2, 2);
        solution.put(3, 3);
        solution.put(4, 4); // key 1 should be evicted
        System.out.println(solution.get(4)); //4
        System.out.println(solution.get(3)); //3
        System.out.println(solution.get(2)); //2
        System.out.println(solution.get(1)); //-1
        solution.put(5, 5); //key 4 should be evicted
        System.out.println(solution.get(1)); //-1, not found
        System.out.println(solution.get(2)); //2
        System.out.println(solution.get(3)); //3
        System.out.println(solution.get(4)); //-1, not found
        System.out.println(solution.get(5)); //5
    }
}
