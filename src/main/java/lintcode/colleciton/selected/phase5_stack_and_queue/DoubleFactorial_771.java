package lintcode.colleciton.selected.phase5_stack_and_queue;

public class DoubleFactorial_771 {
    /**
     * @param n: the given number
     * @return:  the double factorial of the number
     */
    public static long doubleFactorial(int n) {

        // Write your code here
        //Recursion Version
        return calc(n);

        // Write your code here
        // No recursion version -
//        long sum = 1;
//        for (int i = n; i > 0; i = i - 2) {
//            sum *= i;
//        }
//        return sum;
    }

    private static long calc(int n) {
        if (n < 2) {
            return 1;
        }
        return n * calc(n-2);
    }

    public static void main(String[] args) {
        int input = 20;
        System.out.println(doubleFactorial(20));
    }
}
