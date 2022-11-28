package lintcode.dynamicprogramming2;

public class NumberOfWaysSelectBuildings_LE_2222_DP_P2 {
    /*
        ref the solution hint, attack with prefix sum
        - Time is O(N)
        ========================================
        - ref discussion, try a more elegant solution
        ============================================
        P1 10.15.2022
        ============================================
        P2 11.28.2022
    */
    public long numberOfWays(String s) {
        long c1 = 0, c0 = 0, c01 = 0, c10 = 0, c010 = 0, c101 = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '0') {
                c0++;
                c10 += c1;
                c010 += c01;
            } else {
                c1++;
                c01 += c0;
                c101 += c10;
            }
        }
        return c010 + c101;
    }
}
