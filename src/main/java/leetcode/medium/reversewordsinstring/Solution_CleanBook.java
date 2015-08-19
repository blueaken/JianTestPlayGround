package leetcode.medium.reversewordsinstring;

/**
 * Created by jshe18 on 8/17/15.
 */
public class Solution_CleanBook {
    public static String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (reversed.length() != 0) {
                    reversed.append(' ');
                }
                reversed.append(s.substring(i, j));
            }
        }
        return reversed.toString();
    }

    public static void main(String[] args){
//        String input = " the sky is blue ";
        String input = "blue is sky the";
//        String input = " ";
//        String input = "   a   ";

        System.out.println(reverseWords(input));
    }

}
