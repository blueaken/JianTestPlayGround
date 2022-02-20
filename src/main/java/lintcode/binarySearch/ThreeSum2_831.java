package lintcode.binarySearch;

public class ThreeSum2_831 {
    /**
     * @param n: an integer
     * @return: the number of solutions
     */
    //Idea: 找出所有的小于n的完全平方数，套3sum方法，确定两个数然后套二分法变体
    //ref - https://www.lintcode.com/problem/831/solution/18817
    public int threeSum2(int n) {
        // Write your code here
        if (n < 0) {
            return -1;
        }

        int m = (int)Math.round(Math.sqrt(n));
        if (m * m > n) {
            m--;
        }

        int count = 0;
        for (int i = 0; i <= m; i++) {
            int res = n - i * i;
            int start = i, end = m;
            while (start <= end) {
                int diff = res - (start * start + end * end);
                if (diff > 0) {
                    start++;
                } else if (diff < 0) {
                    end--;
                } else {
                    count++;
                    start++;
                }
            }
        }

        return count;

    }
}
