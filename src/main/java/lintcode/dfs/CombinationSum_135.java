package lintcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_135 {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     *          we will sort your return value in output
     */
     /*
        Idea - Combination problem, template slight diff than permutation problem, like NQueens,
             - ref previous notes and https://blog.csdn.net/linhuanmars/article/details/20828631
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }

            list.add(candidates[i]);
            rec (candidates, target - candidates[i], i, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
//        int[] input = {2, 3, 6, 7};
//        int target = 7;

        int[] input = {2, 2, 3};
        int target = 5;

        CombinationSum_135 solution = new CombinationSum_135 ();
        System.out.println(solution.combinationSum(input, target));
    }
}
