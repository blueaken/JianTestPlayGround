package lintcode.prefixsum.diff;

public class RangeAddition_LE_370 {
    /*
        - a straightforward approach is to iterate each update step, and increase accordingly.
        - time is O(N * K), N - the length of arr, K - the number of update queries

        - optimized solution - for each update query, increase the start element and decrease the
          end + 1 element, if exists; then prefix sum the array and get the result;
        - time is O(K + N), brillient
    */
    public int[] getModifiedArray(int length, int[][] updates) {

        int[] arr = new int[length];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];

            arr[start] += val;
            if (end + 1 < length) {
                arr[end+1] -= val;
            }
        }

        //prefixsum the arr
        for (int i = 1; i < length; i++) {
            arr[i] += arr[i-1];
        }
        return arr;
    }
}
