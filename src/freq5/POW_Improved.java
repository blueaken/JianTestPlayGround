package freq5;

/**
 * @author jianshen
 */
public class POW_Improved {
    //level 3
    //the following solution is an improvement to the original one, using recursive binary search idea to improve time performance
    //making it O(logN) from O(N)

    // it looks easy, but tricky, see the comments from flight for your dreams(FFYD):
    //为了正确计算x的n次幂，还需要考虑到以下一些情况：
    //        1) x取值为0时，0的正数次幂是1，而负数次幂是没有意义的；判断x是否等于0不能直接用“==”。
    //        2) 对于n取值INT_MIN时，-n并不是INT_MAX，这时需要格外小心。
    //        3) 尽量使用移位运算来代替除法运算，加快算法执行的速度。
    //http://blog.csdn.net/fengbingyang/article/details/12236121

    public static double pow(double x, int n) {
        if(n < 0){       // 对负数的处理
            return 1.0 / rec(x, n);
        }
        return rec(x, n);
    }

    private static double rec(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        double tmp = rec(x, n/2);
        if ((n&1) == 0){ // tell if even number with bitwise operator
//        if (n%2 == 0){ // tell if even number
            return tmp * tmp;
        } else{
            return tmp * tmp * x;
        }
    }


    public static void main(String[] args){
//        double result = pow(2, 3);
//        double result = pow(2, -3);
        double result = pow(0.44, 0);
        System.out.println("result is: " + result);
    }
}
