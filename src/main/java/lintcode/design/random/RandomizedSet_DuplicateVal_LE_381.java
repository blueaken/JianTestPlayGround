package lintcode.design.random;

import java.util.*;

public class RandomizedSet_DuplicateVal_LE_381 {
    /**
     1.24.24
     - similar to 380, add an index set to handle duplicate values
     */

    LinkedList<Integer> nums;
    Map<Integer, Set<Integer>> val2Idx;

    public RandomizedSet_DuplicateVal_LE_381() {
        nums = new LinkedList<>();
        val2Idx = new HashMap<>();
    }

    public boolean insert(int val) {
        if (!val2Idx.containsKey(val)) {
            val2Idx.put(val, new HashSet<>());
        }

        val2Idx.get(val).add(nums.size());
        nums.addLast(val);

        return val2Idx.get(val).size() == 1;
    }

    public boolean remove(int val) {
        if (!val2Idx.containsKey(val) || val2Idx.get(val).isEmpty()) {
            return false;
        }

        int idx = val2Idx.get(val).iterator().next();
        val2Idx.get(val).remove(idx);

        // swap if not at last position
        int lastIdx = nums.size()-1;
        int lastVal = nums.get(lastIdx);
        if (idx < lastIdx) {
            nums.set(idx, lastVal);
            val2Idx.get(lastVal).remove(lastIdx);
            val2Idx.get(lastVal).add(idx);
        }

        nums.removeLast();
        return true;
    }

    public int getRandom() {
        Random rand = new Random();
        return nums.get(rand.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        RandomizedSet_DuplicateVal_LE_381 solution = new RandomizedSet_DuplicateVal_LE_381();
        System.out.println(solution.insert(1));
        System.out.println(solution.insert(1));
        System.out.println(solution.insert(2));
        System.out.println(solution.insert(1));
        System.out.println(solution.insert(2));
        System.out.println(solution.insert(2));

        System.out.println(solution.remove(1));
        System.out.println(solution.remove(2));
        System.out.println(solution.remove(2));
        System.out.println(solution.remove(2));

        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
    }
}


