package freq5;

/**
 * @author jianshen
 */
public class POW {
    //level 2
    //the following solution works but times out quickly when n is very big, consider a better time performance solution
    public static double pow(double x, int n) {
        if (x == 0.0) return 1;
        if (n == 0) return 1;
        if (n == 1) return x;

        double result = 1.0;
        boolean isNeg = false;
        if (n < 0) {
            isNeg = true;
            n = -n;
        }

        for (int i=0; i<n; i++){
            result *= x;
        }

        if (isNeg) result = 1/result;

        return result;
    }

    public static void main(String[] args){
//        double result = pow(2, 3);
        double result = pow(2, -3);
        System.out.println("result is: " + result);
    }
}
