package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.combinationsum.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 4/1/16 8:35 AM
 */
public class Solution_with_permutation_template {

        public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            // write your code here
            List<List<Integer>>  result = new ArrayList<>();
            if (candidates == null || candidates.length == 0) {
                return result;
            }

            Arrays.sort(candidates);
            rec(candidates, target, result, new ArrayList<Integer>(), 0);
            return result;
        }

        private static void rec(int[] candidates, int target, List<List<Integer>> result,
                                List<Integer> list, int start) {
            int sum = getSumFromList(list);
            if (sum >= target) {
                if (sum == target) {
                    result.add(new ArrayList<>(list));
                }
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                //avoid duplicate elements since each elements can be visited multi times
                if (i != start && candidates[i] == candidates[i-1]) {
                    continue;
                }

                //make sure the result of the list is in ascending order to remove duplicates
                if (candidates[i] > target || (!list.isEmpty() && candidates[i] < list.get(list.size()-1))) {
                    continue;
                }

                list.add(candidates[i]);
                rec(candidates, target, result, list, start);
                list.remove(list.size()-1);
            }
        }

    private static int getSumFromList(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }

        return sum;
    }

        public static void main(String[] args) {
            int target = 7;
            int[] candidates = {2,2,3,7};

//        int target = 6;
//        int[] candidates = {2,3,5};

//        int target = 1;
//        int[] candidates = {1};

//        int target = 2;
//        int[] candidates = {1,1,2};

//        int target = 2;
//        int[] candidates = {1};

            System.out.println(combinationSum(candidates, target));
        }
}
