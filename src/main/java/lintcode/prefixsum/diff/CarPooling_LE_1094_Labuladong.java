package lintcode.prefixsum.diff;

public class CarPooling_LE_1094_Labuladong {
    /**
     12.01.2022
     try solve with 差分数组
     - similar to 370 1109
     - some corner cases to handle
     - might solve with PriorityQueue like Meeting Room2
     ==================
     3.15.2023
     redo with 东哥 template
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        Difference diff = new Difference(nums);
        for (int[] trip : trips) {
            int val = trip[0];
            int i = trip[1];
            int j = trip[2] - 1; // note - passenger leaves at stop j, should not count
            diff.increment(i, j, val);
        }

        int[] res = diff.result();
        for (int n : res) {
            if (n > capacity) {
                return false;
            }
        }
        return true;
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
