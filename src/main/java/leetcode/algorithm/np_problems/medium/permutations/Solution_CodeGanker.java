package leetcode.algorithm.np_problems.medium.permutations;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 2/19/16 10:55 AM
 */
public class Solution_CodeGanker {
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(num==null || num.length==0)
            return res;
        helper(num, new boolean[num.length], new ArrayList<Integer>(), res);
        return res;
    }

    private static void helper(int[] num, boolean[] used, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res)
    {
        if(item.size() == num.length)
        {
            res.add(new ArrayList<>(item));
            return;
        }
        for(int i=0;i<num.length;i++)
        {
            if(!used[i])
            {
                used[i] = true;
                item.add(num[i]);
                helper(num, used, item, res);
                item.remove(item.size()-1);
                used[i] = false;
            }
        }
    }

    public static void main (String[] args){
        int[] test = {1,2,3};

        ArrayList<ArrayList<Integer>> result = permute(test);
        System.out.println(result);
    }
}
