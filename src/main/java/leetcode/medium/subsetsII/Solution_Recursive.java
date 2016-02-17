package leetcode.medium.subsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 2/17/16 2:34 PM
 */
public class Solution_Recursive {
    private static int lastPos;

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
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
        int start = 0;
        if (index>0 && data[index] == data[index-1]) {
            start = lastPos;
        }
        for (int i=start; i<size; i++){
            List<Integer> temp = new ArrayList<>(result.get(i));
            temp.add(data[index]);
            result.add(temp);
        }
        lastPos = size;
    }

    public static void main (String[] args){
        int[] test = {1,2,2};

        List<List<Integer>> result = subsetsWithDup(test);
        System.out.println(result);
    }
}
