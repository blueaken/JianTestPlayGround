package ninechapter_algorithm.chapter1_strstr_to_search_problems.permutations.second;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Author: blueaken
 * Date: 3/31/16 4:21 PM
 */
public class Solution_without_start {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.size() == 0) {
            return result;
        }

        Collections.sort(nums);
        rec(nums, result, new ArrayList<Integer>());
        return result;
    }

    private static void rec(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
        if (list.size() == nums.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (list.contains(nums.get(i))) {
                continue;
            }
            list.add(nums.get(i));
            rec(nums, result, list);
            list.remove(list.size()-1);
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
