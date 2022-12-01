package lintcode.prefixsum.diff;

import java.util.Arrays;

public class RangeAddition_LE_370_P1 {
    /*
        - a straightforward approach is to iterate each update step, and increase accordingly.
        - time is O(N * K), N - the length of arr, K - the number of update queries

        - optimized solution - for each update query, increase the start element and decrease the
          end + 1 element, if exists; then prefix sum the array and get the result;
        - time is O(K + N), brilliant!
    */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int val = updates[i][2];

            res[start] += val;
            if (end + 1 < length) {
                res[end + 1] -= val;
            }
        }

        //prefix the arr and get the result
        for (int i = 1; i < length; i++) {
            res[i] += res[i-1];
        }
        return res;
    }

    public static void main(String[] args) {
        RangeAddition_LE_370_P1 solution = new RangeAddition_LE_370_P1();
        int length = 5;
        int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        //[-2,0,3,5,3]
        System.out.println(Arrays.toString(solution.getModifiedArray(length, updates)));
    }
}
