package lintcode.stack.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxNumberOfBooksYouCanTake_LE_2355 {
    /*
        ref https://leetcode.com/problems/maximum-number-of-books-you-can-take/discuss/2358714/Java-or-Stack-%2B-DP-or-Find-That-Bottleneck-or-Explanations-and-Proof-or-Comments-while-I-was-coding
        and make some modificaiton, but fails on test 81/84
    */
    public long maximumBooks(int[] books) {
        long[] dp = new long[books.length];
        long maxBooks = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < books.length; i++){
            while(!stack.isEmpty() && books[i] < books[stack.peek()]+i-stack.peek()){
                stack.pop();
            }
            int j = stack.isEmpty()? Math.max(0, i-books[i]+1) : stack.peek()+1;

            // dp[i] = 1L*(books[i] * (i-j+1) - (i-j+1) * (i-j) / 2  + (stack.isEmpty()? 0 : dp[j-1]));
            long sum = getSummation(books[i], i-j+1, -1);
            dp[i] = sum + (long)(stack.isEmpty()? 0 : dp[j-1]); //fails on test case 81/84

            maxBooks = Math.max(maxBooks, dp[i]);
            stack.push(i);
        }

        return maxBooks;
    }


    private long getSummation(int a1, int n, int d) {
        // formula of sum of book[i] to book[j] is - n*a1+n(n-1)d/2
        // a1 = books[i]
        // n = i - j + 1
        // d = -1
        // Sn = books[i] * (i-j+1) - (i-j+1) * (i-j) / 2

        return (long)((long)(n*a1)+(long)(n*(n-1)*d)/2);
    }
}
