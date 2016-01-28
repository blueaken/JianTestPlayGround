package leetcode.easy.reverseinteger.second;

/**
 * Author: blueaken
 * Date: 1/28/16 3:32 PM
 */
public class Solution {
    public static int reverse(int x) {
        int overflowcheck = Integer.MAX_VALUE/10;

        int ret = 0;
        while (x!=0){
            if (Math.abs(ret)>overflowcheck){
                return 0;
            }
            ret = ret*10 + x%10;
            x /= 10;
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
