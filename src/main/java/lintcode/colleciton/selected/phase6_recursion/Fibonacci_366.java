package lintcode.colleciton.selected.phase6_recursion;

public class Fibonacci_366 {
    /**
     * @param n: an integer
     * @return: an ineger f(n)
     */
    //Key Idea: Time is O(n^2), ref: https://blog.csdn.net/weixin_45445598/article/details/107457366
    public int fibonacci(int n) {
        // write your code here
        return helper(n);
    }

    private int helper(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        return helper(n-1) + helper(n-2);
    }
}
