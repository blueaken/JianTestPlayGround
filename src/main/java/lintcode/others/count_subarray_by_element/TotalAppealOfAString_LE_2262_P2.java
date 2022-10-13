package lintcode.others.count_subarray_by_element;

import java.util.Arrays;

public class TotalAppealOfAString_LE_2262_P2 {
    /*
        P1
        - note the diff with 828, unique char vs distinct
        - also there is duplicate chars, only count the 1st char's contribution, for example
        - X X a X X a X X a X
        -1    j     i        n
        (i - j) * (n - i)
        ==============================
        P2 10.13.2022
        ref previous notes
    */
    public long appealSum(String s) {
        int n = s.length();
        int[] lastPos = new int[26];
        Arrays.fill(lastPos, -1);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = s.charAt(i) - 'a';
            ans += (i - lastPos[cur]) * (n - i);

            lastPos[cur] = i;
        }
        return ans;
    }
}
