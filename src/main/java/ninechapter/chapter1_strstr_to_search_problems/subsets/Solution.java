package ninechapter.chapter1_strstr_to_search_problems.subsets;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 2/20/16 11:02 PM
 */
public class Solution {
    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        ArrayList<Integer> item = new ArrayList<>();
        Arrays.sort(nums);
        rec(result, item, nums, 0);

        return result;
    }

    private static void rec(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> item, int[]nums, int index) {
        result.add(new ArrayList<>(item));

        for (int i = index; i < nums.length; i++){
            item.add(nums[i]);
            rec(result, item, nums, i + 1);
            item.remove(item.size()-1);
        }
    }

    public static void main (String[] args){
        int[] test = {1,2,3};

        ArrayList<ArrayList<Integer>> result = subsets(test);
        System.out.println(result);
    }
}
