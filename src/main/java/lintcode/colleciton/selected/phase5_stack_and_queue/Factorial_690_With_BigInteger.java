package lintcode.colleciton.selected.phase5_stack_and_queue;

import java.math.BigInteger;

public class Factorial_690_With_BigInteger {
    /**
     * @param n: an integer
     * @return:  the factorial of n
     */
    public String factorial(int n) {
        // write your code here
        if (n < 2) return "1";
        BigInteger sum = new BigInteger("1");
        for (int i = n; i > 1; i--) {
            sum = sum.multiply(new BigInteger(String.valueOf(i)));
        }
        return String.valueOf(sum);
    }
}
