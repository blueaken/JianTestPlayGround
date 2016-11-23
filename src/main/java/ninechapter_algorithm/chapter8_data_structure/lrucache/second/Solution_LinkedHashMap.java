package ninechapter_algorithm.chapter8_data_structure.lrucache.second;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 6/2/16 12:05
 */
public class Solution_LinkedHashMap {
    private Map<Integer, Integer> map;
    private int capacity;

    // @param capacity, an integer
    public Solution_LinkedHashMap(int capacity) {
        // write your code here
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (map.containsKey(key)) {
            int val = map.get(key);
            map.remove(key);
            map.put(key, val);
            return val;
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
        } else {
            if (map.size() < this.capacity) {
                map.put(key, value);
            } else {
                int firstKey = -1;
                Iterator<Integer> iterator = map.keySet().iterator();
                firstKey = iterator.next();
                map.remove(firstKey);
                map.put(key, value);
            }
        }
    }
}
