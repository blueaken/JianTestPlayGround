package leetcode.np_problems.medium.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 2/19/16 11:30 AM
 */
public class Solution_Iteractive {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        List<Integer> init = new ArrayList<>();
        init.add(nums[0]);
        result.add(init);

        for(int i=1; i<nums.length; i++){
            List<List<Integer>> tempResult = new ArrayList<>();
            for (int j=0; j<result.size(); j++){
                List<Integer> cur = result.get(j);
                for (int k=0; k<cur.size()+1;k++){
                    List<Integer> item = new ArrayList<>(cur);
                    item.add(k, nums[i]);
                    tempResult.add(item);
                }
            }

            result = tempResult;
        }

        return result;
    }

    public static void main (String[] args){
        int[] test = {1,2,3};

        List<List<Integer>> result = permute(test);
        System.out.println(result);
    }
}
