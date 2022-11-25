package lintcode.prefixsum;

public class PlatesBetweenCandles_LE_2055_P2 {
    /*
        ref Huifeng Guan notes - https://github.com/wisdompeak/LeetCode/tree/master/Greedy/2055.Plates-Between-Candles
        - presum is the best to solve this
        - use 2 arraies next and last to record each pos's pre and next candle position
        - if the query is valid then count the presum of plates
        - Time is O(N + M) - N is the number chars of s, M is the number of queries

        - P1
        - Type: Presum
        ==========================
        P2 11.25.2022
        ==========================
    */
    public int[] platesBetweenCandles(String s, int[][] queries) {
        //build the prefix sum array for plates
        int n = s.length();
        int[] ps = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (cur == '*') {
                count++;
            }
            ps[i] = count;
        }

        //build last and next array records previous and next candle position
        int[] last = new int[n];
        int pos = -1;
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (cur == '|') {
                pos = i;
            }
            last[i] = pos;
        }

        int[] next = new int[n];
        pos = n;
        for (int i = n-1; i >= 0; i--) {
            char cur = s.charAt(i);
            if (cur == '|') {
                pos = i;
            }
            next[i] = pos;
        }

        //get the query result from previous calc
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            int x = next[start], y = last[end];//notice should not be last[start] & next[end]
            if (x < y) {
                ans[i] = ps[y] - ps[x];
            }
        }

        return ans;
    }
}
