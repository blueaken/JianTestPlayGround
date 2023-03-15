package lintcode.prefixsum.diff;

public class RangeAddition_LE_370_Labuladong {
    /*
        - a straightforward approach is to iterate each update step, and increase accordingly.
        - time is O(N * K), N - the length of arr, K - the number of update queries

        - optimized solution - for each update query, increase the start element and decrease the
          end + 1 element, if exists; then prefix sum the array and get the result;
        - time is O(K + N), brilliant!
        ==============================
        P2 11.24.2022
        ==============================
        3.15.2023
        redo with 东哥Difference class template
    */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        Difference diff = new Difference(nums);
        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            diff.increment(i, j, val);
        }
        return diff.result();
    }

    class Difference {
        int[] diff;

        Difference(int[] nums) {
            diff = new int[nums.length];
            for (int i = 1; i < diff.length; i++) {
                diff[i] = nums[i] - nums[i-1];
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j+1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < res.length; i++) {
                res[i] = res[i-1] + diff[i];
            }
            return res;
        }
    }
}
