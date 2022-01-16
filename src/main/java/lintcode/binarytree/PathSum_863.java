package lintcode.binarytree;

import java.util.HashMap;
import java.util.Map;

public class PathSum_863 {
    Map<Integer, Integer> map = new HashMap<>();
    int ans = 0;
    /**
     * @param nums: a list of integers
     * @return: return an integer
     */
    //Ideal: Using HashMap, ref: https://www.lintcode.com/problem/863/solution/17010
    public int pathSum(int[] nums) {
        // write your code here
        if (nums.length == 0) return ans;

        for (int i : nums) {
            //depth and pos as key, value as value, then -
            //depth = key / 10, pos = key % 10
            //left child key = (depth + 1) * 10 + 2 * pos - 1
            //right child key = left child key + 1;
            map.put(i/10, i%10);
        }

        dfs(nums[0]/10, 0);
        return ans;
    }

    private void dfs(int node, int sum) {
        if (!map.containsKey(node)) {
            return;
        }
        sum += map.get(node);
        int depth = node / 10;
        int pos = node % 10;
        int leftKey = (depth + 1) * 10 + 2 * pos - 1;
        int rightKey = leftKey + 1;
        if (!map.containsKey(leftKey) && !map.containsKey(rightKey)) {
            ans += sum;
            return;
        }
        dfs (leftKey, sum);
        dfs (rightKey, sum);
    }

    public static void main(String[] args) {
        int[] input = {113, 215, 221};
        PathSum_863 solution = new PathSum_863();
        System.out.println(solution.pathSum(input));
    }
}
