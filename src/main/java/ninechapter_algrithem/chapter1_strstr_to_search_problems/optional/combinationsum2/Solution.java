package ninechapter_algrithem.chapter1_strstr_to_search_problems.optional.combinationsum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 3/24/16 5:30 PM
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
        List<Integer> path = new ArrayList<>();
        rec(num, result, target, path, 0);
        return result;
    }

    private static void rec(int[] num, List<List<Integer>> result, int target, List<Integer> path, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < num.length; i++) {
            if (num[i] > target) {
                break;
            }

            if (i != start && num[i] == num[i-1]) {
                continue;
            }

            path.add(num[i]);
            rec(num, result, target - num[i], path, i+1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int target = 7;
        int[] candidates = {2,2,3,7};

        System.out.println(combinationSum2(candidates, target));
    }
}
