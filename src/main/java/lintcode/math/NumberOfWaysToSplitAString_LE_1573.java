package lintcode.math;

public class NumberOfWaysToSplitAString_LE_1573 {

    /**
     12.25.23
     try after the hint
     ref https://leetcode.com/problems/number-of-ways-to-split-a-string/solutions/830455/java-python-3-multiplication-of-the-ways-of-1st-and-2nd-cuts-w-explanation-and-analysis/
     */
    public int numWays(String s) {
        int mod = (int)1e9+7;

        long sum = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            sum += s.charAt(i) - '0';
        }

        if (sum == 0) {
            return (int)((n - 2L) * (n - 1L) / 2 % mod);
        }

        if (sum % 3 != 0) {
            return 0;
        }

        long onesInEachBlock = sum / 3;
        long firstCutWays = 0, secondCutWays = 0;
        for (int i = 0, count = 0; i < n; ++i) {
            count += s.charAt(i) - '0';
            if (count == onesInEachBlock) {
                firstCutWays++;
            }else if (count == 2 * onesInEachBlock) {
                secondCutWays++;
            }
        }

        return (int)(firstCutWays * secondCutWays % mod);
    }

}
