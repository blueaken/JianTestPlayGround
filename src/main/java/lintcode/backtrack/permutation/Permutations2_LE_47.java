package lintcode.backtrack.permutation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations2_LE_47 {
    /**
     1.9.2023
     ref 东哥 post
     使用回溯框架全排列Solution
     注意对重复元素的剪枝条件使用!used[i-1], 保持所有重复元素的相对位置
     */
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        //base case
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            // 剪枝
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }

            used[i] = true;
            track.add(nums[i]);
            backtrack(nums);
            track.removeLast();
            used[i] = false;
        }
    }
}
