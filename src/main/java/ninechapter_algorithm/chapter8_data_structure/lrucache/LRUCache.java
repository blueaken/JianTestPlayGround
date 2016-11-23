package ninechapter_algorithm.chapter8_data_structure.lrucache;

import java.util.*;

/**
 * Author: blueaken
 * Date: 5/2/16 11:54
 */
public class LRUCache {
    private Map<Integer, Integer> map;
    private int capacity;

    // @param capacity, an integer
    public LRUCache(int capacity) {
        // write your code here
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity);
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        } else {
            return -1;
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        }  else {
            if (map.size() < capacity) {
                map.put(key, value);
            } else {
                //init listIterator with map.size() to make sure it start from the end
                ListIterator<Integer> iterator = new ArrayList<>(map.keySet()).listIterator();
                int lastKey = -1;
                if (iterator.hasNext()) {
                    lastKey = iterator.next();
                }
                map.remove(lastKey);
                map.put(key,value);
            }
        }
    }

    public static void main(String[] args) {
        //expect: 1,-1,1
//        LRUCache cache = new LRUCache(2);
//        cache.set(2, 1);
//        cache.set(1, 1);
//        System.out.println(cache.get(2));
//        cache.set(4, 1);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));

        //expect: 4,3,2,-1,-1,2,3,-1,5
        LRUCache cache = new LRUCache(3);
        cache.set(1, 1);
        cache.set(2, 2);
        cache.set(3, 3);
        cache.set(4, 4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.set(5, 5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
    }
}
