package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.combinationsum2.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 4/1/16 8:58 AM
 */
public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public static List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) {
            return result;
        }

        Arrays.sort(num);
        rec(num, target, result, new ArrayList<Integer>(), 0);
        return result;
    }

    private static void rec(int[] num, int target, List<List<Integer>> result,
                            List<Integer> list, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
        }

        for (int i = start; i < num.length; i++) {
            if (i != start && num[i] == num[i-1] || num[i] > target) {
                continue;
            }

            list.add(num[i]);
            rec(num, target-num[i], result, list, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        //expect [[1,7],[1,2,5],[2,6],[1,1,6]]
        int target = 8;
        int[] candidates = {10,1,6,7,2,1,5,0};

        System.out.println(combinationSum2(candidates, target));
    }
}
