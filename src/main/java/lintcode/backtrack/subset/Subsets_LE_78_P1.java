package lintcode.backtrack.subset;

import java.util.LinkedList;
import java.util.List;

public class Subsets_LE_78_P1 {
    /**
     1.9.2023
     - ref 东哥 post, 使用回溯框架
     - 可以注意一下回溯框架在Subset和全排列上的区别
     =================
     3.2.2023
     P1
     */
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i+1);
            track.removeLast();
        }
    }
}
