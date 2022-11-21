package lintcode.binarysearch;

public class SQRT2_586 {
    /**
     * @param x: a double
     * @return: the square root of x
     */
    //Idea: 当参数为long类型时，每次循环start和end会不断接近，但不会相等，需要通过eps来控制精度；
    public double sqrt(double x) {
        // write your code here
        double start = 0;
        double end = Math.max(x, 1.0);
        double eps = 1e-8; //精度控制

        while (start + eps < end) {
            double mid = start + (end - start) / 2;
            if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        double x = 2;
        SQRT2_586 solution = new SQRT2_586();
        System.out.println(solution.sqrt(x));
    }
}
