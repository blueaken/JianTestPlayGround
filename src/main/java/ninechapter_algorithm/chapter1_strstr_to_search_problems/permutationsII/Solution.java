package ninechapter_algorithm.chapter1_strstr_to_search_problems.permutationsII;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 2/21/16 12:51 PM
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
        boolean[] visited = new boolean[nums.size()];
        rec(nums, item, visited, result);

        return result;
    }

    private static void rec(ArrayList<Integer> nums, ArrayList<Integer> item, boolean[] visited, ArrayList<ArrayList<Integer>> result){
        if (item.size() == nums.size()){
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i=0; i<nums.size(); i++){

            if (visited[i] || i!=0 && nums.get(i) == nums.get(i-1) && !visited[i-1]){
                continue;
            }

            item.add(nums.get(i));
            visited[i] = true;
            rec(nums, item, visited, result);
            visited[i] = false;
            item.remove(item.size()-1);
        }
    }

    public static void main (String[] args){
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(2);

        ArrayList<ArrayList<Integer>> result = permute(test);
        System.out.println(result);
    }
}
