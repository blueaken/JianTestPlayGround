package leetcode.algorithm.np_problems.medium.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 2/17/16 9:09 AM
 */
public class Solution_Iterative {

    public static List<List<Integer>> subsets(int[] num) {
        if(num == null) return null;
        Arrays.sort(num);  // make sure the result elements is of ascending order

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        result.add(temp);

        for (int i=0;i<num.length;i++){
            int size = result.size();
            for (int j=0;j<size;j++){
                temp = new ArrayList<>(result.get(j));
                temp.add(num[i]);
                result.add(temp);
            }
        }
        return result;
    }

    public static void main (String[] args){
        int[] test = {1,2,3};

        List<List<Integer>> result = subsets(test);
        System.out.println(result);
    }
}
