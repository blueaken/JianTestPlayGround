package lintcode.dynamicprogramming;

public class ClimbStairs_111_REC {
    /**
     * @param n: An integer
     * @return: An integer
     */
    //Idea: 简单的DP，到达第n阶的方案数为到第n-1阶和n-2阶方案数的总和;
    //Ref - https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/FibonacciSeries.java
    public int climbStairs(int n) {
        // write your code here
        if (n == 1 || n == 0) {
            return 1;
        }

        return climbStairs(n-1) + climbStairs(n-2);
    }

    public static void main(String[] args) {
        int input = 6;

        ClimbStairs_111_REC solution = new ClimbStairs_111_REC();
        System.out.println(solution.climbStairs(input));
    }
}
