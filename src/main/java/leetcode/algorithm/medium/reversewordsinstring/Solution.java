package leetcode.algorithm.medium.reversewordsinstring;

/**
 * Created by jshe18 on 8/17/15.
 */
public class Solution {
    public static String reverseWords(String s) {
        if (s==null || s.trim().length()==0){
            return "";
        }

        char[] input = s.toCharArray();
        char[] output = new char[input.length+1];

        int iend = input.length-1;
        int istart;
        int ostart = 0;

        while (iend>=0){
            while (iend>=0 && input[iend] == ' '){
                iend--;
            }
            istart = iend;
            while (istart>=0 && input[istart]!=' '){
                istart--;
            }
            istart++;

            int temp = istart;
            while (istart<=iend) {
                output[ostart++] = input[istart++];
            }

            output[ostart++] = ' ';

            if (temp-1==0){
                break;
            }else{
                iend = temp-1;
            }
        }

        String result = new String(output, 0, output.length-1);
        return result.trim();
    }

    public static void main(String[] args){
//        String input = " the sky is blue ";
        String input = "blue is sky the";
//        String input = " ";
//        String input = "   a   ";

        System.out.println(reverseWords(input));
    }
}
