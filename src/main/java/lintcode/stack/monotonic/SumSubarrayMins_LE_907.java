package lintcode.stack.monotonic;

import java.util.ArrayList;
import java.util.List;

public class SumSubarrayMins_LE_907 {
    /*
        Idea: use the lps dp template to found the list of sub arrays, then sum the mins
        Time - O(N^2), not AC TLE
    */
    public int sumSubarrayMins(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int size = arr.length;

        List<List<Integer>> subarrays = new ArrayList<>();
        for (int len = 1; len <= size; len ++) {
            for (int i = 0; i <= size - len; i++) {
                int j = i + len - 1;
                List<Integer> sub = new ArrayList<>();
                int start = i, end = j;
                while (start <= end) {
                    sub.add(arr[start++]);
                }
                subarrays.add(sub);
            }
        }

        int sum = 0;
        for (List<Integer> sub : subarrays) {
            sum += getMin(sub);
        }
        return sum;
    }

    private int getMin(List<Integer> sub) {
        int ans = Integer.MAX_VALUE;
        for (Integer i : sub) {
            ans = Math.min(ans, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        SumSubarrayMins_LE_907 solution = new SumSubarrayMins_LE_907();
        int[] input = {3,1,2,4};//17

        System.out.println(solution.sumSubarrayMins(input));
    }
}
