package ninechapter_algorithm.chapter9_graphic.optional.ksum2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 6/15/16 08:49
 */
public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null || A.length == 0) {
            return result;
        }

        Arrays.sort(A);
        rec(result, A, k, target, new ArrayList<Integer>(), 0);
        return result;
    }

    private void rec(ArrayList<ArrayList<Integer>> result, int[] A, int k, int target,
                     ArrayList<Integer> list, int index) {
        if (list.size() == k || target <= 0) {
            if (list.size() == k && target == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = index; i < A.length; i++) {
            list.add(A[i]);
            rec(result, A, k, target - A[i], list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
