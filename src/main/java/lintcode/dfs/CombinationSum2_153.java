package lintcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2_153 {
    /**
     * @param candidates: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     *          we will sort your return value in output
     */
     /*
        Idea - similar to combination sum, but template slightly different
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        rec (candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void rec (int[] candidates, int target, int pos, List<Integer> list, List<List<Integer>> res) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            //avoid duplicates
            if (i != pos && candidates[i] == candidates[i - 1]) {
                continue;
            }

            list.add(candidates[i]);
            rec (candidates, target - candidates[i], i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] input = {7,1,2,5,1,6,10};
        int target = 8;

        CombinationSum2_153 solution = new CombinationSum2_153 ();
        System.out.println(solution.combinationSum2(input, target));
    }
}
