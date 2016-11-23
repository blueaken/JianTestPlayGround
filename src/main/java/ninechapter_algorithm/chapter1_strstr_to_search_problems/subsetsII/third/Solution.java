package ninechapter_algorithm.chapter1_strstr_to_search_problems.subsetsII.third;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Author: blueaken
 * Date: 6/10/16 09:25
 */
public class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (S == null || S.size() == 0) {
            return result;
        }

        Collections.sort(S);
        rec(S, result, new ArrayList<Integer>(), 0);
        return result;
    }

    private void rec(ArrayList<Integer> S, ArrayList<ArrayList<Integer>> result,
                     ArrayList<Integer> list, int index) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < S.size(); i++) {
            if (i != index && S.get(i) == S.get(i - 1)) {
                continue;
            }
            list.add(S.get(i));
            rec(S, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
