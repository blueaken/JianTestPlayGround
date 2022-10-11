package lintcode.stack.monotonic;

import java.util.Stack;

public class MaxNumberOfBooksYouCanTake_LE_2355 {
    /*
        还是Huifeng Guan讲得清楚 - https://www.youtube.com/watch?v=iJsbDfza-qk
        dp[i] - the max number of books you can take from an subarry ending at i, now the question is where is the left boundary
        X X X [ X 3 9 9 9] X
                  j     i  k
            dp[j] + 7 8 9

         dp[i] = dp[j] + sum(等差数列)
         等差数列长度 L = i - j
         和 = (首项 + 末项) * L / 2 = (books[i] + books[i] - L + 1) * L / 2
       ---------------------------------------------
       when k > books[i], dp[k] = dp[i] + books[k]; (here i = j)
       when k < books[i], dp[k] = dp[j] + sum(j+1 : k)
       --------------------------------------------
       use monotonic stack for perf, note: use '1L' in front of books[i] when calc 等差数列和 to avoid overflow
    */
    public long maximumBooks(int[] books) {
        int n = books.length;
        long[] dp = new long[n];
        Stack<Integer> stack = new Stack<>();//index

        long ans = 0;
        for (int i = 0; i < n; i++) {
            //如果stack top element能和当前元素i组成等差数列，则Pop
            while (stack.size() > 0 && books[stack.peek()] > (books[i] - (i - stack.peek()))) {
                stack.pop();
            }
            //找到了j的位置，可以用上面公式dp[k] = dp[j] + sum(j+1 : k)计算，注意有2种情况
            if (stack.size() > 0) {
                int len = i - stack.peek();
                dp[i] = dp[stack.peek()] + 1L * (books[i] + books[i] - len + 1) * len / 2;
            } else {
                //如果Stack为Empty则整个subarray都可以作为等差数列，len = i + 1, 但注意等差数列首项要大于0
                //如这种情况：10 10 10 10 10 3，等差数列长度为3，而不是6
                int len = Math.min(i+1, books[i]);
                dp[i] = 1L * (books[i] + books[i] - len + 1) * len / 2;
            }
            stack.push(i);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
