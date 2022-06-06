package lintcode.string;

public class CountBinarySubstrings_LE_696_LinearSolution_Practice1 {
    public int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        int group_no = 0;
        groups[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i-1)) {
                groups[++group_no] = 1;
            } else {
                groups[group_no] += 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < group_no; i++) {
            ans += Math.min(groups[i], groups[i+1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        CountBinarySubstrings_LE_696_LinearSolution_Practice1 solution = new CountBinarySubstrings_LE_696_LinearSolution_Practice1();
        String input = "00110011"; //6

        System.out.println(solution.countBinarySubstrings(input));
    }
}
