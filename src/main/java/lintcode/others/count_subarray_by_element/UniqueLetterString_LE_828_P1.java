package lintcode.others.count_subarray_by_element;

public class UniqueLetterString_LE_828_P1 {
    /*
        - gut feeling is brute force search, Time is O(N^2), N is the length of string
        - it TLEs with no surprise
        - note in the brute force solution, countUniqueChars() is called multiple times for the same substring, it should be optimized.

        - reading the solution link of brilliant O(N) solution, but it does not optimize countUniqueChars(), have to read it triple times to understand
        - ref: https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/discuss/129021/O(N)-Java-Solution-DP-Clear-and-easy-to-Understand
    */
    public int uniqueLetterString(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] contribution = new int[26];
        int[] lastContribution = new int[26];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'A';

            int totalNumOfSubStringEndingHere = i + 1;
            contribution[cur] = totalNumOfSubStringEndingHere - lastContribution[cur];

            int curCharContribution = 0;
            for (int j = 0; j < 26; j++) {
                curCharContribution += contribution[j];
            }

            ans += curCharContribution;

            lastContribution[cur] = i + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        UniqueLetterString_LE_828_P1 solution = new UniqueLetterString_LE_828_P1();
        String S = "ABCBD";//27
        System.out.println(solution.uniqueLetterString(S));
    }
}
