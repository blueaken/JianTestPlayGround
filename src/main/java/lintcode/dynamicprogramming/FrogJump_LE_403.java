package lintcode.dynamicprogramming;

import java.util.*;

public class FrogJump_LE_403 {
    /**
     12.29.23
     dp + mem
     ref huifeng guan video - https://www.youtube.com/watch?v=gq4q_PeF9pQ
     */
    Set<Integer> stonePosSet;
    Map<Integer, Set<Integer>> failedMem;
    public boolean canCross(int[] stones) {
        int n = stones.length;
        stonePosSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            stonePosSet.add(stones[i]);
        }
        failedMem = new HashMap<>(); // pos + k pair

        return dfs(stones, 0, 0);
    }

    boolean dfs(int[]stones, int pos, int k) {
        // 3 base cases
        if (pos == stones[stones.length-1]) {
            return true;
        }
        if (!stonePosSet.contains(pos)) {
            return false;
        }
        if (failedMem.keySet().contains(pos) && failedMem.get(pos).contains(k)){
            return false;
        }

        // try 3 jump steps
        if (k > 1 && dfs(stones, pos+k-1, k-1)) {
            return true;
        }
        if (k > 0 && dfs(stones, pos+k, k)) {
            return true;
        }
        if (dfs(stones, pos+k+1, k+1)) {
            return true;
        }

        failedMem.putIfAbsent(pos, new HashSet<>());
        failedMem.get(pos).add(k);
        return false;
    }

    public static void main(String[] args) {
        FrogJump_LE_403 solution = new FrogJump_LE_403();
//        int[] stones = new int[]{0,1,3,5,6,8,12,17};
//        // true
        int[] stones = {0,1,3,6,7};
        // false

        System.out.println(solution.canCross(stones));
    }
}
