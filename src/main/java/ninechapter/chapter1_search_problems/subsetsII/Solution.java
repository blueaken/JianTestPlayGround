package ninechapter.chapter1_search_problems.subsetsII;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Author: blueaken
 * Date: 2/20/16 11:02 PM
 */
public class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (S==null || S.size() == 0) return result;

        Collections.sort(S);
        ArrayList<Integer> item = new ArrayList<>();
        rec(S, 0, item, result);
        return result;
    }

    private static void rec(ArrayList<Integer> data, int pos, ArrayList<Integer> item,
                     ArrayList<ArrayList<Integer>> result){
        result.add(new ArrayList<>(item));

        for (int i=pos; i<data.size(); i++){
            if (i != pos && data.get(i) == data.get(i-1)){
                continue;
            }
            item.add(data.get(i));
            rec(data, i+1, item, result);
            item.remove(item.size()-1);
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
