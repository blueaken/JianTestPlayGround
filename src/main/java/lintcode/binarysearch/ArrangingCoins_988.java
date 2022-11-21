package lintcode.binarysearch;

public class ArrangingCoins_988 {
    /**
     * @param n: a non-negative integer
     * @return: the total number of full staircase rows that can be formed
     */
    public int arrangeCoins(int n) {
        // Write your code here
        // // Solution 1: 一行行减，直到不能放满，返回当前行数，O（n）
        // if (n == 0) {
        //     return 0;
        // }
        // int rem = n - 1, cur = 1;
        // while (rem > cur + 1) {
        //     cur++;
        //     rem -= cur;
        // }
        // return cur;

        // Solution 2: 利用等差数列公式 S = （n/2）* （2a + （n-1）d），a是首项 1， d是公差1，化简得到 S = n * (n + 1) / 2, n是项数
        // 利用Binary Search，O(log n)
        // Note, 前行和可能会溢出，所有变量声明为long
        if (n < 2) {
            return n;
        }
        long start = 1, end = n;
        while (start < end) {
            long mid = start + (end - start) / 2;
            long cur = mid * (mid + 1) / 2;
            if ( cur < n) {
                start = mid + 1;
            } else if (cur == n) {
                return (int)mid;
            } else {
                end = mid;
            }
        }

        return (int)start - 1;
    }
}
