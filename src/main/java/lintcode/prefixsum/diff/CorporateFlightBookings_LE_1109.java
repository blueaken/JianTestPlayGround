package lintcode.prefixsum.diff;

public class CorporateFlightBookings_LE_1109 {
    /**
     12.1.2022
     差分 type
     similar to 370
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int start = bookings[i][0] - 1;
            int end = bookings[i][1] - 1;
            int val = bookings[i][2];

            res[start] += val;
            if (end + 1 < n) {
                res[end+1] -= val;
            }
        }

        for (int i = 1; i < n; i++) {
            res[i] += res[i-1];
        }
        return res;
    }
}
