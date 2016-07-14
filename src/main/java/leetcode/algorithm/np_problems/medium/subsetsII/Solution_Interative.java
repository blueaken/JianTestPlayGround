package leetcode.algorithm.np_problems.medium.subsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 2/17/16 2:50 PM
 */
public class Solution_Interative {

    private static int lastPos;

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        if (nums == null) return null;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        result.add(temp);

        for (int i=0; i<nums.length; i++){
            int size = result.size();
            int start = 0;
            if (i>0 && nums[i]==nums[i-1]){
                start = lastPos;
            }
            for (int j=start; j<size; j++){
                temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
            lastPos = size;
        }

        return result;
    }

    public static void main (String[] args){
        int[] test = {1,2,2};

        List<List<Integer>> result = subsetsWithDup(test);
        System.out.println(result);
    }
}
