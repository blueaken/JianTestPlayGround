package lintcode.backtrack.subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets_LE_78 {
    /**
     1.9.2022
     - ref 东哥 post, 使用回溯框架
     - 可以注意一下回溯框架在Subset和全排列上的区别
     - 我们使用 start 参数控制树枝的生长避免产生重复的子集，用 track 记录根节点到每个节点的路径的值，同时在前序位置把每个节点的路径值收集起来，完成回溯树的遍历就收集了所有子集
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
