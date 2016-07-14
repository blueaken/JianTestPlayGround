package leetcode.algorithm.medium.missingranges;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 1/26/16 3:58 PM
 */
public class Solution {
    public static List<String> findMissingRanges(int[] vals, int start, int end) {
        List<String> result = new ArrayList<>();
        int prev = start - 1;

        for (int i=0; i<=vals.length; i++){
            int cur = (i==vals.length ? (end+1) : vals[i]);
            if (cur - prev > 1){
                result.add(getRange(prev+1, cur-1));
            }
            prev = cur;
        }

        return result;
    }

    private static String getRange(int from, int to){
        return from == to ? String.valueOf(from) : from + "->" + to;
    }

    public static void main(String[] args){
//        int[] input = {0, 1, 3, 50, 75};
        int[] input = {};
        int start = 0;
        int end = 99;

        List<String> result = findMissingRanges(input, start, end);
        for (String s : result){
            System.out.println(s);
        }
    }

}
