package lintcode.backtrack.subset;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets2_LE_90 {
    /**
     1.9.2023
     ref 东哥 post
     回溯框架subset问题，加对重复元素路径剪枝
     */
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            // 剪枝
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }

            track.add(nums[i]);
            backtrack(nums, i+1);
            track.removeLast();
        }
    }
}
