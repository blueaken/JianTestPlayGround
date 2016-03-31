package ninechapter_algorithm.chapter1_strstr_to_search_problems.subsetsII.second;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Author: blueaken
 * Date: 3/31/16 3:25 PM
 */
public class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (S == null || S.size() == 0) {
            return result;
        }

        Collections.sort(S);
        rec(S, result, new ArrayList<Integer>(), 0);
        return result;
    }

    private static void rec(ArrayList<Integer> S, ArrayList<ArrayList<Integer>> result,
                       ArrayList<Integer> list, int start) {
        result.add(new ArrayList<>(list));

        for (int i = start; i < S.size(); i++) {
            if (i != start && S.get(i) == S.get(i-1)) {
                continue;
            }
            list.add(S.get(i));
            rec(S, result, list, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main (String[] args){
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(2);

        ArrayList<ArrayList<Integer>> result = subsetsWithDup(test);
        System.out.println(result);
    }
}
