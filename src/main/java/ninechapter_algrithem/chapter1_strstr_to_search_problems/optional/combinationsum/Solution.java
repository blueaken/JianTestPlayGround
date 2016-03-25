package ninechapter_algrithem.chapter1_strstr_to_search_problems.optional.combinationsum;

import java.util.*;

/**
 * Author: blueaken
 * Date: 3/16/16 5:46 PM
 */
public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        List<Integer> item = new ArrayList<>();
        Arrays.sort(candidates);
        rec(candidates, target, result, item, 0);

        return result;
    }

    static void rec(int[] nums, int target, List<List<Integer>> result, List<Integer> item, int start){
//        if (target <= 0) {
            if (target == 0) {
                result.add(new ArrayList<>(item));
                return;
            }
//            return;
//        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }

            if(i != start && nums[i]==nums[i-1])  {
                continue;
            }

            item.add(nums[i]);
            rec(nums, target - nums[i], result, item, i);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        int target = 7;
        int[] candidates = {2,2,3,7};

//        int target = 25;
//        int[] candidates = {4,8,11,10,9,3,12,7,6};

//        int target = 1;
//        int[] candidates = {1};

//        int target = 2;
//        int[] candidates = {1,1,2};

//        int target = 2;
//        int[] candidates = {1};

        System.out.println(combinationSum(candidates, target));
    }
}
