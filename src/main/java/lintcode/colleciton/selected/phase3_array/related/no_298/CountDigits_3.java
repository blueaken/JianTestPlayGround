package lintcode.colleciton.selected.phase3_array.related.no_298;

public class CountDigits_3 {
    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int count = 0;
        for (int i = k; i <= n; i++) {
            count += singleDigitCount(k, i);
        }
        return count;
    }

    private int singleDigitCount(int k, int n) {
        if (k == n) {
            return 1;
        }
        int count = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit == k) {
                count++;
            }
            n /= 10;
        }
        return count;
    }
}
