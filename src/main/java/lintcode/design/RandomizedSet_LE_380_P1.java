package lintcode.design;

import java.util.*;

public class RandomizedSet_LE_380_P1 {
    /**
     12.15.2022
     ref 东哥 帖子，same as before
     */
    List<Integer> list;
    Map<Integer, Integer> map;
    public RandomizedSet_LE_380_P1() {
        list = new ArrayList<>();
        map = new HashMap<>(); //value, index
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        int size = list.size();
        map.put(val, size);
        list.add(size, val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int lastIdx = list.size() - 1;
        int lastVal = list.get(lastIdx);

        int idx = map.get(val);
        map.put(lastVal, idx);
        list.set(idx, lastVal);

        list.remove(lastIdx);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}
