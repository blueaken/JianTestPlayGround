package lintcode.dfs;

import java.util.ArrayList;
import java.util.List;

/*
    Idea: similar to Combination & Combination2, adjust the parameters slightly
 */
public class CombinationSum3_LE_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> res = new ArrayList<>();
        rec (nums, res, new ArrayList<Integer>(), n, k, 0);
        return res;
    }

    private void rec (int[] nums, List<List<Integer>> res, List<Integer> list, int target, int k, int pos) {
        if (target <= 0 || list.size() == k) {
            if (target == 0 && list.size() == k) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            rec (nums, res, list, target - nums[i], k, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int target = 9;

        CombinationSum3_LE_216 solution = new CombinationSum3_LE_216 ();
        System.out.println(solution.combinationSum3(k, target));
    }
}
