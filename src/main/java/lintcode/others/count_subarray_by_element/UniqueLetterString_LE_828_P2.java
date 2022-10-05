package lintcode.others.count_subarray_by_element;

public class UniqueLetterString_LE_828_P2 {
    /*
        P2
        - read previous notes
        - type: count subarray by element
    */
    public int uniqueLetterString(String s) {
        int[] lastCon = new int[26];
        int[] contribution = new int[26];

        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = s.charAt(i) - 'A';
            int contributionEndingAtCur = i + 1;
            contribution[cur] = contributionEndingAtCur - lastCon[cur];

            for (int j = 0; j < 26; j++) {
                ans += contribution[j];
            }
            lastCon[cur] = i + 1;
        }
        return ans;
    }
}
