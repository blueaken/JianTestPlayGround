package lintcode.colleciton.selected.phase5_stack_and_queue;

public class Factorial_690_With_Recursion {
    /**
     * @param n: an integer
     * @return:  the factorial of n
     */
    //Ref: https://www.geeksforgeeks.org/factorial-large-number/
    public static String factorial(int n) {
        // write your code here

        int ret[] = new int[10000];
        ret[0] = 1;
        int size = 1;

        //apply factorial calculated by multiply digit by digit of the ret array
        for (int x = 2; x <= n; x++) {
            size = multiply(x, ret, size);
        }

        //format the result with reverse order of ret array
        StringBuilder sb = new StringBuilder();
        for (int i = size-1; i >= 0; i--) {
            sb.append(ret[i]);
        }
        return sb.toString();
    }

    private static int multiply(int multiplier, int[] ret, int size) {
        int carry = 0;
        for (int i = 0; i < size; i++) {
            int prod = ret[i] * multiplier + carry;
            ret[i] = prod % 10;
            carry = prod / 10;
        }

        while (carry != 0) {
            int digit = carry % 10;
            carry = carry / 10;
            ret[size] = digit;
            size++;
        }
        return size;
    }

    public static void main(String[] args) {
        int input = 15;
        System.out.println(factorial(input));
    }
}
