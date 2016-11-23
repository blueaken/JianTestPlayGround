package leetcode.algorithm.np_problems.medium.permutationsII;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 2/19/16 12:14 PM
 */
public class Solution_Lintcode {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public static ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.size() == 0){
            return result;
        }

        boolean[] used = new boolean[nums.size()];
        ArrayList<Integer> item = new ArrayList<>();
        rec(nums, 0, item, used, result);

        return result;
    }

    private static void rec(ArrayList<Integer> nums, int index, ArrayList<Integer> item, boolean[] used,
                     ArrayList<ArrayList<Integer>> result){
        if (index == nums.size()){
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i=0; i<nums.size(); i++){
            if (i>0 && used[i-1] && nums.get(i) == nums.get(i-1)) continue;
            if (!used[i]){
                item.add(nums.get(i));
                used[i] = true;
                rec(nums, index + 1, item, used, result);
                used[i] = false;
                item.remove(item.size()-1);
            }
        }
    }

    public static void main (String[] args){
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(2);

        ArrayList<ArrayList<Integer>> result = permuteUnique(test);
        System.out.println(result);
    }
}
