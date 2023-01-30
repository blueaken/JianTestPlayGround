package lintcode.graph.unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence_LE_128_UnionFind {
    /*
        - note the diff with 1143. Longest Common SubSequence
        - ref 花花 https://www.youtube.com/watch?v=rc2QdQ7U78I，if O(n) not required, then just sort then sort the
          longest consecutive sequence; there are 2 solutions
        - 1. HashMap
        ==========================================================
        - 2. Union find, the important is the idea
        - ref Huifeng Guan - https://www.youtube.com/watch?v=QnBcLxgeeGs
        - 1st Union Find problem, the comment is verbose
    */
    Map<Integer, Integer> father = new HashMap<>(); //Node, Father; here Father refers to ancestor

    public int longestConsecutive(int[] nums) {
        //to skip duplicates nodes, not elegant, but the idea is union find itself
        Set<Integer> nodes = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            nodes.add(cur);
            //if new node, refers the father to itself
            if (!father.containsKey(cur)) {
                father.put(cur, cur);
            } else {
                //skip duplicate nodes
                continue;
            }

            //if left neighbor exists and not have same father, union them with union find method
            if (father.containsKey(cur-1) && findFather(cur-1) != findFather(cur)) {
                union(cur, cur-1);
            }
            //same as right neighbor
            if (father.containsKey(cur+1) && findFather(cur+1) != findFather(cur)) {
                union(cur, cur+1);
            }
        }

        //compress union find path, adjust all nodes of same group to one father
        for (int cur : nodes) {
            father.put(cur, findFather(cur));
        }

        //count the largest group
        Map<Integer, Integer> count = new HashMap<>(); //Father, Num;
        for (int cur : nodes) {
            int curFather = father.get(cur);
            count.put(curFather, count.getOrDefault(curFather, 0) + 1);
        }

        int ans = 0;
        for (Integer n : count.keySet()) {
            ans = Math.max(ans, count.get(n));
        }
        return ans;
    }

    //Union Find 2 utility methods
    private int findFather(int x) {
        int curFather = father.get(x);
        if ( curFather != x) {
            father.put(x, findFather(curFather));
        }
        return father.get(x);
    }

    private void union(int x, int y) {
        //randomly choose one node's father as common father, here choose the bigger
        x = father.get(x);
        y = father.get(y);
        if (x > y) {
            father.put(y, x);
        } else {
            father.put(x, y);
        }
        return;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence_LE_128_UnionFind solution = new LongestConsecutiveSequence_LE_128_UnionFind();
        int[] nums = {100,4,200,1,3,2};//4
        System.out.println(solution.longestConsecutive(nums));
    }
}
