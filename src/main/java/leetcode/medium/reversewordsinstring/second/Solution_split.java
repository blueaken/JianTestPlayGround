package leetcode.medium.reversewordsinstring.second;

/**
 * Author: blueaken
 * Date: 12/11/15 3:12 PM
 */
public class Solution_split {
    public static String reverseWords(String s) {
        String space = " ";
        String[] array = s.split(space);
        StringBuilder sb = new StringBuilder();
        int i = array.length-1;
        while (i>=0) {
            if (array[i].equalsIgnoreCase("")) {
                i--;
                continue;
            }

            sb.append(array[i--]);
            sb.append(space);
        }

        return sb.toString().trim();
    }

    public static void main(String[] args){
//        String input = " the sky is blue ";
//        String input = " ";
        String input = "";
//        String input = "   a   ";
//        String input = " 1";
//        String input = "   a   b ";

        System.out.println(reverseWords(input));
    }
}
