package leetcode.easy.stringtointeger;

/**
 * Created by jshe18 on 8/19/15.
 */
public class Solution {
    public static int atoi(String str) {
        int no_conversion = 0;

        str = str.trim();
        if (str.length() == 0){
            return no_conversion;
        }

        //handle sign
        boolean isNeg = false;
        char c = str.charAt(0);
        if (c == '+'){
            str = str.substring(1);
        }else if (c == '-'){
            isNeg = true;
            str = str.substring(1);
        }

        //handle digit
        char[] input = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<input.length; i++){
            if (!Character.isDigit(input[i])){
                if (sb.length()==0) return no_conversion;
                break;
            }
            sb.append(input[i]);
        }

        //check overflow
        String eval = sb.toString();
        if (isNeg) {
            eval = "-" + eval;
        }

        long result;
        try {
            result = Long.valueOf(eval);
        }catch (NumberFormatException nfe){
            return no_conversion;
        }

        if (result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if (result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        return (int)result;
    }

    public static void main(String[] args){
//        String input = "234";
//        String input = "234bcv";
//        String input = "-234";
//        String input = "-234bcv";
//        String input = "   ";
//        String input = "+234";
//        String input = "bc345";
//        String input = String.valueOf(Integer.MAX_VALUE);
        String input = "9223372036854775809";

        System.out.println(atoi(input));
    }
}
