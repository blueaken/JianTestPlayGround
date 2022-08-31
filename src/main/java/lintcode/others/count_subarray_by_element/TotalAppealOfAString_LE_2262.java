package lintcode.others.count_subarray_by_element;

import java.util.Arrays;

public class TotalAppealOfAString_LE_2262 {
    /*
        - similar to 828, this type called "aggregate subarray be element" by Guifeng Guan
        - Brute Force is obvious, but for 10^5 data size, got TLE easily
        - ref 828's elegant O(N) solution and Guifeng Guan's video
        - https://leetcode.com/submissions/detail/712659035/
        - https://www.youtube.com/watch?v=yItx_wB0Epg
    */
    public long appealSum(String s) {

        int n = s.length();

        int[]lastPos = new int[26];
        Arrays.fill(lastPos, -1);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            ans += (i - lastPos[cur -  'a']) * (n - i);

            lastPos[cur - 'a'] = i;
        }

        return ans;
    }

    /*
    X X X a X X [X X a X a X X]
          j          i       n-1 n

    Appeal value of a(i) = (i - j) * (n - i), j default to -1

    if there is duplicate char, count the left appeal value
    */
}
