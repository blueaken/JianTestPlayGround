package lintcode.string;

public class ReverseString2_LE_541 {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 || k < 2) {
            return s;
        }

        int pos = 0;
        int count = 1;
        boolean isRev = true;
        StringBuilder buffer = new StringBuilder();
        StringBuilder res = new StringBuilder();
        while (pos < s.length()) {
            if (count <= k) {
                buffer.append(s.charAt(pos++));
                count++;
                continue;
            }
            if (isRev) {
                buffer.reverse();
            }
            res.append(buffer);
            buffer = new StringBuilder();
            isRev = !isRev;
            count = 1;
        }
        //process the last part of buffer
        if (buffer.length() > 0) {
            if (isRev) {
                buffer.reverse();
            }
            res.append(buffer);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ReverseString2_LE_541 solution = new ReverseString2_LE_541();
//        String s = "abcdefg";
//        int k = 2;
//        //"bacdfeg"
        String s = "abcd";
        int k = 4;
        //"bcba"

        System.out.println(solution.reverseStr(s, k));
    }
}
