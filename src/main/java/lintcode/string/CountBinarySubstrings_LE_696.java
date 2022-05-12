package lintcode.string;

// using DP LPS template, O(N^2) time, get TLE
public class CountBinarySubstrings_LE_696 {
    public int countBinarySubstrings(String s) {
        int len = s.length();
        boolean[][] res = new boolean[len+1][len+1];
        int count = 0;
        for (int l = 1; l <= len; l++) {
            for (int i = 0; i <= len - l; i++) {
                int j = i + l - 1;
                String curString = s.substring(i, j + 1);
                res[i+1][j+1] = isValid(curString);
                if (res[i+1][j+1]) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isValid (String s) {
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }

        int i = 0, j = len - 1;
        while (i < j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (i > 0 && c1 != s.charAt(i-1)
                    || j < len - 1 && c2 != s.charAt(j+1)
                    || (c1 ^ c2) == 0 ) {
                return false;
            }
            i++; j--;
        }
        return true;
    }

    public static void main(String[] args) {
        CountBinarySubstrings_LE_696 solution = new CountBinarySubstrings_LE_696();
//        String input = "10101"; //4
        String input = "00110011"; //6

        System.out.println(solution.countBinarySubstrings(input));
    }
}
