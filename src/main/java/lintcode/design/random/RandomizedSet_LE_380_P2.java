package lintcode.design.random;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet_LE_380_P2 {
    /**
     12.15.2022
     ref 东哥 帖子，same as before
     ============
     03.27.2023
     P1
     */

    List<Integer> nums;
    Map<Integer, Integer> valToIdx;

    public RandomizedSet_LE_380_P2() {
        nums = new ArrayList<>();
        valToIdx = new HashMap<>();
    }

    public boolean insert(int val) {
        if (valToIdx.containsKey(val)) {
            return false;
        }

        int idx = nums.size();
        valToIdx.put(val, idx);
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIdx.containsKey(val)) {
            return false;
        }

        int lastIdx = nums.size() - 1;
        int lastVal = nums.get(lastIdx);

        // swap with last value
        int curIdx = valToIdx.get(val);
        nums.set(lastIdx, val);
        nums.set(curIdx, lastVal);
        valToIdx.put(lastVal, curIdx);

        // remove last position
        nums.remove(lastIdx);
        valToIdx.remove(val);
        return true;
    }

    public int getRandom() {
        Random rand = new Random();
        return nums.get(rand.nextInt(nums.size()));
    }

}
