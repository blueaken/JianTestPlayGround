package ninechapter_algorithm.chapter1_strstr_to_search_problems.permutationsII.second;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Author: blueaken
 * Date: 4/1/16 9:10 AM
 */
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public static ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.size() == 0) {
            return result;
        }

        Collections.sort(nums);
        boolean[] visited = new boolean[nums.size()];
        rec(nums, result, new ArrayList<Integer>(), visited, 0);
        return result;
    }

    private static void rec(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, boolean[] visited, int start) {
        if (list.size() == nums.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.size(); i++) {
            if (visited[i] || i!=0 && nums.get(i) == nums.get(i-1) && visited[i-1]) {
                continue;
            }

            list.add(nums.get(i));
            visited[i] = true;
            rec(nums, result, list, visited, start);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }

    public static void main (String[] args){
        /*
         expect:
         [
              [1,2,2],
              [2,1,2],
              [2,2,1]
            ]
         */
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(2);

        ArrayList<ArrayList<Integer>> result = permuteUnique(test);
        System.out.println(result);
    }
}
