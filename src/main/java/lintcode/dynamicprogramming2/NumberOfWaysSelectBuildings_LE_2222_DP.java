package lintcode.dynamicprogramming2;

public class NumberOfWaysSelectBuildings_LE_2222_DP {
    /*
        ref the solution hint, attack with prefix sum
        - Time is O(N)
        ========================================
        - ref discussion, try a more elegant solution
    */
    public long numberOfWays(String s) {

        long n0 = 0, n1 = 0, n01 = 0, n10 = 0, n010 = 0, n101 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                n0++;
                n10 += n1;
                n010 += n01;
            } else {
                n1++;
                n01 += n0;
                n101 += n10;
            }
        }
        return n010 + n101;
    }
}
