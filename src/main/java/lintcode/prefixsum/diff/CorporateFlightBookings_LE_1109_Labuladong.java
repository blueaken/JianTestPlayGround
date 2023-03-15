package lintcode.prefixsum.diff;

public class CorporateFlightBookings_LE_1109_Labuladong {
    /**
     12.1.2022
     差分 type
     similar to 370
     ================
     3.15.2023
     redo with 东哥 template
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int res[] = new int[n];
        Difference diff = new Difference(res);
        for (int[] booking : bookings) {
            int i = booking[0];
            int j = booking[1];
            int seats = booking[2];
            diff.increment(i-1, j-1, seats);
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
