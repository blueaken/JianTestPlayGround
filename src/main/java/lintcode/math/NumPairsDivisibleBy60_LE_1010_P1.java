package lintcode.math;

public class NumPairsDivisibleBy60_LE_1010_P1 {
    /*
        P1
        - idea is to put len % 60 into an arr of size 60, and process it along one iterate, similar to 2Sum solution
    */
    public int numPairsDivisibleBy60(int[] time) {
        int[] rem = new int[60];
        int ans = 0;
        for (int t : time) {
            int cur = t % 60;
            if (cur == 0) {
                ans += rem[0];
            } else {
                ans += rem[60-cur];
            }
            rem[cur]++;
        }
        return ans;
    }
}
