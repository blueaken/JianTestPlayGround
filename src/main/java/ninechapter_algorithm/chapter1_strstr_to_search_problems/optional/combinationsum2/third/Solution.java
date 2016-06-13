package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.combinationsum2.third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 6/13/16 16:57
 */
public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) {
            return result;
        }

        Arrays.sort(num);
        rec(result, num, target, new ArrayList<Integer>(), 0);
        return result;
    }

    private void rec(List<List<Integer>> result, int[] num, int target,
                     List<Integer> list, int index) {
        if (target <= 0) {
            if (target == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = index; i < num.length; i++) {
            if (i != index && num[i] == num[i - 1]) {
                continue;
            }
            list.add(num[i]);
            rec(result, num, target - num[i], list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
