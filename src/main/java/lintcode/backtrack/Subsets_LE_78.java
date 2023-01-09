package lintcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets_LE_78 {
    /**
     1.9.2022
     - ref 东哥 post, 使用回溯框架
     - 可以注意一下回溯框架在Subset和全排列上的区别
     */

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        // 前序位置，每个节点的值都是一个子集
        res.add(new ArrayList<>(track));

        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i+1);
            track.removeLast();
        }
    }
}
