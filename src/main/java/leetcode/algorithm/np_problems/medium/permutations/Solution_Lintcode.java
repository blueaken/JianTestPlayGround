package leetcode.algorithm.np_problems.medium.permutations;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 2/19/16 9:41 AM
 */
public class Solution_Lintcode {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */

    private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) return result;

        ArrayList<Integer> item = new ArrayList<>();
        boolean[] used = new boolean[nums.size()];
        rec(nums, 0, item, used);

        return result;
    }

    private static void rec(ArrayList<Integer> nums, int index, ArrayList<Integer> item, boolean[] used){
        if (index == nums.size()){
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i=0; i<nums.size(); i++){
            if (used[i]){
                continue;
            }
            item.add(nums.get(i));
            used[i] = true;
            rec(nums, index + 1, item, used);
            used[i] = false;
            item.remove(item.size() - 1);
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
