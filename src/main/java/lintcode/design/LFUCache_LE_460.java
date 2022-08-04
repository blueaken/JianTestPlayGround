package lintcode.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
    - 146 LRU Cache的进阶，代码会比较多，因为需要实现O(1)时间, 未必会直接考，但可能会问如何实现。结合花花的视频，可以用HashMap + Doubly LinkedList实现，或者HashMap + Balanced Binary Tree, 但这种情况时间会是O(log capacity)
    - ref https://zxi.mytechroad.com/blog/hashtable/leetcode-460-lfu-cache/
    - 146 我用了自己实现的Doubly LinkedList, 这里参考花花的讲解用LinkedList
*/
public class LFUCache_LE_460 {
    class CacheNode {
        Integer key;
        Integer value;
        Integer freq;

        CacheNode(Integer key, Integer value, Integer freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }

    }

    int capacity;
    int minFreq;
    Map<Integer, CacheNode> cacheNodeMap = new HashMap<>(); // key, cacheNode
    Map<Integer, LinkedList<Integer>> freqListMap = new HashMap<>(); // frequency, list of node keys

    public LFUCache_LE_460(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (cacheNodeMap.containsKey(key)) {
            CacheNode cur = cacheNodeMap.get(key);
            touch(cur);
            return cur.value;
        } else {
            return -1;
        }
    }

    /*
        - maintain the frequency relationship of the freqList map
     */
    private void touch(CacheNode node) {
        //1. update the node frequency value & add back to cache node map
        Integer prevFreq = node.freq;
        Integer curFreq = prevFreq + 1;
        cacheNodeMap.get(node.key).freq++;

        //2. remove the entry from prev frequency's list and update minFreq if needed
        freqListMap.get(prevFreq).remove(node.key);

        if (freqListMap.get(prevFreq).size() == 0 && prevFreq == minFreq) {
            freqListMap.remove(prevFreq);
            minFreq++;
        }

        //3. insert the key to the front of the new frequency list
        LinkedList<Integer> keys = freqListMap.getOrDefault(curFreq, new LinkedList<>());
        keys.addFirst(node.key);
        freqListMap.put(curFreq, keys);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (cacheNodeMap.containsKey(key)) {
            //key already exists, update the value of touch it
            cacheNodeMap.get(key).value = value;
            CacheNode cur = cacheNodeMap.get(key);
            touch(cur);
            return;
        }

        if (cacheNodeMap.size() == capacity) {
            //no capacity - need to remove the node that
            // 1. has the lowest capacity
            // 2. least recently used if multiple nodes shares the same least frequency

            //Step 1. remove the last element from the min_freq list
            Integer keyToEvict = freqListMap.get(minFreq).pollLast();
            //what if freqListMap.get(minFreq) is empty now?, clear from the freqList map?

            //Step 2. remove the key from cache node map
            cacheNodeMap.remove(keyToEvict);
        }

        // the new item's freq is always 1, thus set minFreq to 1
        int freq = 1;
        minFreq = freq;

        //add the key to the freqList map
        LinkedList<Integer> keys = freqListMap.getOrDefault(freq, new LinkedList<>());
        keys.addFirst(key);
        freqListMap.put(freq, keys);

        //add a new node in cacheNode map
        cacheNodeMap.put(key, new CacheNode(key, value, freq));
    }

    public static void main(String[] args) {
        LFUCache_LE_460 solution = new LFUCache_LE_460(2);
        solution.put(1, 1);
        solution.put(2, 2);
        System.out.println(solution.get(1)); //1
        solution.put(3, 3); //key 2 should be evicted
        System.out.println(solution.get(2)); //-1, not found
        System.out.println(solution.get(3)); //3
        solution.put(4, 4);//both 1 & 3 has the same frequency now, but 1 is LRU, so 1 is evicted
        System.out.println(solution.get(1)); //-1, not found
        System.out.println(solution.get(3)); //3
        System.out.println(solution.get(4)); //4
    }
}
