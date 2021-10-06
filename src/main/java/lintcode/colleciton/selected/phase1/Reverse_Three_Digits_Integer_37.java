package lintcode.colleciton.selected.phase1;

public class Reverse_Three_Digits_Integer_37 {
    /**
     * @param number: A 3-digit number.
     * @return: Reversed number.
     * ref: https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode-solution-bccn/
     * better solution
     */
    public static int reverseInteger(int number) {
        // write your code here
        char[] temp = Integer.valueOf(number).toString().toCharArray();
        char a = temp[0];
        char b = temp[1];
        char c = temp[2];

        char[] result = null;
        if (c != 0) {
            result = new char[] {c,b,a};
        } else if (b != 0) {
                result = new char[]{b,a};
        } else {
            result = new char[]{a};
        }

        return result == null ? -1 : Integer.valueOf(String.valueOf(result));
    }

    public static int reverseInteger_official (int number) {
        int ret = 0;
        while (number != 0) {
            int x = number % 10;
            number /= 10;
            ret = ret * 10 + x;
        }
        return ret;
    }

    public static void main(String[] args){
//        int input = 321;
//        int input = 230;
        int input = 200;
        System.out.println(reverseInteger(input));
        System.out.println(reverseInteger_official(input));
    }
}
