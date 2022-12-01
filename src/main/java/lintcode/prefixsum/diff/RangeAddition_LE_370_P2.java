package lintcode.prefixsum.diff;

public class RangeAddition_LE_370_P2 {
    /*
        - a straightforward approach is to iterate each update step, and increase accordingly.
        - time is O(N * K), N - the length of arr, K - the number of update queries

        - optimized solution - for each update query, increase the start element and decrease the
          end + 1 element, if exists; then prefix sum the array and get the result;
        - time is O(K + N), brilliant!
        ==============================
        P2 11.24.2022
        ==============================
    */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int val = updates[i][2];

            res[start] += val;
            if (end < length-1) {
                res[end+1] -= val;
            }
        }

        for (int i = 1; i < length; i++) {
            res[i] += res[i-1];
        }
        return res;
    }
}
