package lintcode.colleciton.selected.phase3_array;

public class ReverseWords1_53 {
    /*
     * @param s: A string
     * @return: A string
     */
    public static String reverseWords(String s) {
        // write your code here
        if (s.isEmpty()) return s;

        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].isEmpty()) continue;

            sb.append(arr[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
//        String input = "the sky is blue";
        String input = "  Life  doesn't  always    give     us  the       joys we want.";
        System.out.println(reverseWords(input));
    }
}
