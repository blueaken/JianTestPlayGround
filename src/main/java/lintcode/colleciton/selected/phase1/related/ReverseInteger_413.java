package lintcode.colleciton.selected.phase1.related;

public class ReverseInteger_413 {
    /**
     * @param n: the integer to be reversed
     * @return: the reversed integer
     * * ref: https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode-solution-bccn/
     */
    public static int reverseInteger(int n) {
        // write your code here
        int ret = 0;
        int upper_overflow_flag = Integer.MAX_VALUE / 10;
        int lower_overflow_flag = Integer.MIN_VALUE / 10;
        while (n != 0) {
            int x = n % 10;
            n /= 10;

            //return 0 if result is overflown
            if ((upper_overflow_flag < ret) || (upper_overflow_flag == ret && (x > Integer.MAX_VALUE % 10))) {
                return 0;
            }
            if ((lower_overflow_flag > ret) || (lower_overflow_flag == ret && (x < Integer.MIN_VALUE % 10))) {
                return 0;
            }

            ret = ret * 10 + x;
        }
        return ret;
    }

    public static void main(String[] args){
//        int input = 321;
//        int input = 230;
        int input = -123;
        System.out.println(reverseInteger(input));
    }
}
