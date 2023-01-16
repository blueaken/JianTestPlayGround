package lintcode.math.factor;

public class FactorialTrailingZeroes_LE_172 {
    /**
     1.16.2023
     ref东哥post, 问题转化为n!可以分解出多少分子为5，注意25，50，75这样，可以提供提供额外的一个5，以此类推
     */
    public int trailingZeroes(int n) {
        int divisor = 5;
        int res = 0;
        while (divisor <= n) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }
}
