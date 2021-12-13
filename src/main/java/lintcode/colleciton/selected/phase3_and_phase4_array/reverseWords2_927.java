package lintcode.colleciton.selected.phase3_and_phase4_array;

public class reverseWords2_927 {

    /**
     * @param str: a string
     * @return: return a string
     * 没有对多个空格的处理要求
     */
    //挑战不分配额外空间
    public static char[] reverseWords(char[] str) {
        // write your code here
        int len = str.length;
        if (len == 0) return str;
        reverse(str, 0, len - 1);

        int slow = 0; int fast = 0;
        while (slow < len) {
            while (fast < len && str[fast] != ' ') {
                fast++;
            }
            reverse(str, slow, fast - 1);

            while (fast < len && str[fast] == ' ') {
                fast++;
            }
            slow = fast;
        }
        return str;
    }

    private static void reverse(char[] arr, int start, int end) {
        if (arr.length == 0) return;
        char temp;
        while (end > start) {
            temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
        return;
    }

    /***************************************************
     *
      */
    //with String split method
//    public static char[] reverseWords(char[] str) {
//        // write your code here
//        String s = String.valueOf(str);
//        if (s.isEmpty()) return str;
//
//        String[] arr = s.split(" ");
//        StringBuilder sb = new StringBuilder();
//        for (int i = arr.length - 1; i >= 0; i--) {
//            if (arr[i].isEmpty()) continue;
//
//            sb.append(arr[i]);
//            sb.append(" ");
//        }
//
//        String rev = sb.toString().trim();
//        return rev.toCharArray();
//    }

    public static void main(String[] args) {
//        String input = "the sky is blue";
        String input = "  Life  doesn't  always    give     us  the       joys we want.";
        System.out.println(reverseWords(input.toCharArray()));
    }
}
