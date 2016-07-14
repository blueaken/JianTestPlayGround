package leetcode.algorithm.easy.reverseinteger;

/**
 * Created by jshe18 on 8/21/15.
 */
public class Solution_CleanBook {
    private static int OVERFLOW_CHECK = Integer.MAX_VALUE/10;

    public static int reverse(int x) {
        int ret = 0;
        while (x!=0){
            if (Math.abs(ret)>OVERFLOW_CHECK){
                return 0;
            }
            ret = ret*10 + x%10;
            x = x/10;
        }

        return ret;
    }

    public static void main(String[] args){
//        int x = 321;
//        int x = -321;
//        int x = 0;
//        int x = 10100;
        int x = 1000000003;

        System.out.println(reverse(x));
    }

}
