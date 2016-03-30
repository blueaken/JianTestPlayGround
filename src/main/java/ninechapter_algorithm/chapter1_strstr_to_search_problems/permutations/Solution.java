package ninechapter_algorithm.chapter1_strstr_to_search_problems.permutations;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 2/21/16 12:43 PM
 */
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new  ArrayList<>();
        if (nums == null || nums.size() == 0) return result;

        ArrayList<Integer> item = new ArrayList<>();
        rec(nums, item, result);

        return result;
    }

    private static void rec(ArrayList<Integer> nums, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result){
        if (item.size() == nums.size()){
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i=0; i<nums.size(); i++){
            if (!item.contains(nums.get(i))){
                item.add(nums.get(i));
                rec(nums, item, result);
                item.remove(item.size()-1);
            }
        }
    }

    public static void main (String[] args){
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);

        ArrayList<ArrayList<Integer>> result = permute(test);
        System.out.println(result);
    }
}
