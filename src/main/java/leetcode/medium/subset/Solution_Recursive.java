package leetcode.medium.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 2/17/16 9:32 AM
 */
public class Solution_Recursive {
    public static List<List<Integer>> subsets(int[] nums) {
        // write your code here
        if (nums == null) return null;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        rec(nums, nums.length-1, result);
        return result;
    }

    private static void rec(int[] data, int index, List<List<Integer>> result){
        if (index == -1) {
            List<Integer> temp = new ArrayList<>();
            result.add(temp);
            return;
        }

        rec(data, index-1, result);
        int size = result.size();
        for (int i=0; i<size; i++){
            List<Integer> temp = new ArrayList<>(result.get(i));
            temp.add(data[index]);
            result.add(temp);
        }
    }

    public static void main (String[] args){
        int[] test = {1,2,3};

        List<List<Integer>> result = subsets(test);
        System.out.println(result);
    }
}
