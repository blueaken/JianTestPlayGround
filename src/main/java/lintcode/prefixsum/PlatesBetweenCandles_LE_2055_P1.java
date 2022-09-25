package lintcode.prefixsum;

public class PlatesBetweenCandles_LE_2055_P1 {
    /*
        ref Huifeng Guan notes - https://github.com/wisdompeak/LeetCode/tree/master/Greedy/2055.Plates-Between-Candles
        - presum is the best to solve this
        - use 2 arraies next and last to record each pos's pre and next candle position
        - if the query is valid then count the presum of plates
        - Time is O(N + M) - N is the number chars of s, M is the number of queries

        - P1
        - Type: Presum
    */
    public int[] platesBetweenCandles(String s, int[][] queries) {

        int n = s.length();
        int[] ps = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                count++;
            }
            ps[i] = count;
        }

        int[] last = new int[n];
        int pos = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                pos = i;
            }
            last[i] = pos;
        }

        int[] next = new int[n];
        pos = n;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                pos = i;
            }
            next[i] = pos;
        }

        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int[] query = queries[i];
            int start = query[0], end = query[1];
            int x = next[start], y = last[end];
            if (x == n || y == -1 || x == y) {
                continue;
            }
            if (x < y) {
                ans[i] = ps[y] - ps[x];
            }
        }
        return ans;
    }
}
