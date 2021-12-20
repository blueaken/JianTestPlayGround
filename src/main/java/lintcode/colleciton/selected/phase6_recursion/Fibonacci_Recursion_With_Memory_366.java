package lintcode.colleciton.selected.phase6_recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci_Recursion_With_Memory_366 {
    public Map<Integer, Integer> note = new HashMap<>();
    /**
     * @param n: an integer
     * @return: an ineger f(n)
     */
    //Key Idea: Time is O(n), ref: https://blog.csdn.net/weixin_45445598/article/details/107457366
    public int fibonacci(int n) {
        // write your code here
        return helper(n);
    }

    private int helper(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        if (note.containsKey(n)) {
            return note.get(n);
        } else {
            int res = helper(n-1) + helper(n-2);
            note.put(n, res);
            return res;
        }
    }
}
