package lintcode.backtrack.subset;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets2_LE_90_P1 {
    /**
     1.9.2023
     ref 东哥 post
     回溯框架subset问题，加对重复元素路径剪枝
     ==================
     3.2.2023
     P1
     */

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, 0);
        return res;
    }

    private void backTrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            // remove duplicate - 东哥 combination template
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }

            track.add(nums[i]);
            backTrack(nums, i+1);
            track.removeLast();
        }
    }
}
