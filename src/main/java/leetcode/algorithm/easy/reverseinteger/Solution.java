package leetcode.algorithm.easy.reverseinteger;

/**
 * Created by jshe18 on 8/20/15.
 */
public class Solution {
    public static int reverse(int x) {
        String input = String.valueOf(x);
        boolean isNeg = false;
        if (input.charAt(0) == '-'){
            isNeg = true;
            input = input.substring(1);
        }

        char[] arr = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        if (isNeg) sb.append('-');

        for (int i=input.length()-1; i>=0; i--){
            if (arr[i] == 0){
                i++;
            }
            sb.append(arr[i]);
        }

        if (sb.length()==0){
            return 0;
        }

        Long output = Long.valueOf(sb.toString());
        if (output > Integer.MAX_VALUE || output < Integer.MIN_VALUE) return 0;

        return output.intValue();
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
