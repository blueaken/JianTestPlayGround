package leetcode.algorithm.np_problems.medium.permutations;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 2/19/16 11:22 AM
 */
public class Solution_CodeGanker_Iteractive {

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(num == null || num.length==0)
            return res;
        ArrayList<Integer> first = new ArrayList<>();
        first.add(num[0]);
        res.add(first);

        for(int i=1;i<num.length;i++)
        {
            ArrayList<ArrayList<Integer>> newRes = new ArrayList<>();
            for(int j=0;j<res.size();j++)
            {
                ArrayList<Integer> cur = res.get(j);
                for(int k=0;k<cur.size()+1;k++)
                {
                    ArrayList<Integer> item = new ArrayList<>(cur);
                    item.add(k,num[i]);
                    newRes.add(item);
                }
            }
            res = newRes;
        }
        return res;
    }

    public static void main (String[] args){
        int[] test = {1,2,3};

        ArrayList<ArrayList<Integer>> result = permute(test);
        System.out.println(result);
    }
}
