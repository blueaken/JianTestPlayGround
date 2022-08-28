package lintcode.dynamicprogramming2;

public class NumberOfWaysSelectBuildings_LE_2222 {
    /*
        ref the solution hint, attack with prefix sum
        - Time is O(N)
    */
    public long numberOfWays(String s) {

        int len = s.length();

        //build presum 0 & 1 arr
        long[] ps0 = new long[len];
        long[] ps1 = new long[len];
        if (s.charAt(0) == '0') {
            ps0[0] = 1;
        } else {
            ps1[0] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                ps0[i] = ps0[i-1] + 1;
                ps1[i] = ps1[i-1];
            } else {
                ps0[i] = ps0[i-1];
                ps1[i] = ps1[i-1] + 1;
            }
        }

        //build presum 01 & 10 arr
        long[] ps01 = new long[len];
        long[] ps10 = new long[len];
        if (s.charAt(1) == '0') {
            ps10[1] = ps1[0];
        } else {
            ps01[1] = ps0[0];
        }
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                ps10[i] = ps1[i-1] + ps10[i-1];
                ps01[i] = ps01[i-1];
            } else {
                ps01[i] = ps0[i-1] + ps01[i-1];
                ps10[i] = ps10[i-1];
            }
        }

        //build presum 010 & 101 arr
        long[] ps010 = new long[len];
        long[] ps101 = new long[len];
        if (s.charAt(2) == '0') {
            ps010[2] = ps01[1];
        } else {
            ps101[2] = ps10[1];
        }
        for (int i = 3; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                ps010[i] = ps01[i-1] + ps010[i-1];
                ps101[i] = ps101[i-1];
            } else {
                ps101[i] = ps10[i-1] + ps101[i-1];
                ps010[i] = ps010[i-1];
            }
        }

        return ps010[len-1] + ps101[len-1];
    }
}
