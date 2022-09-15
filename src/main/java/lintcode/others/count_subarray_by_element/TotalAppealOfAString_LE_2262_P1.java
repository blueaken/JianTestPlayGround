package lintcode.others.count_subarray_by_element;

import java.util.Arrays;

public class TotalAppealOfAString_LE_2262_P1 {
    /*
        P1
        - note the diff with 828, unique char vs distinct
        - also there is duplicate chars, only count the 1st char's contribution, for example
        - X X a X X a X X a X
        -1    j     i        n
        (i - j) * (n - i)
    */
    public long appealSum(String s) {
        int[] lastContri = new int[26];
        Arrays.fill(lastContri, -1); //default to -1

        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            ans += (i - lastContri[cur]) * (s.length() - i);
            lastContri[cur] = i;
        }
        return ans;
    }
}
