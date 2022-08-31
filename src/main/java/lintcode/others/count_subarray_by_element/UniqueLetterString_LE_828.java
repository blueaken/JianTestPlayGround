package lintcode.others.count_subarray_by_element;

public class UniqueLetterString_LE_828 {
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

        int[] lastPositionContribution = new int[26];
        int[] contribution = new int[26];

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            //note the string only consists of uppercase letters
            contribution[cur - 'A'] = i + 1 - lastPositionContribution[cur - 'A'];
            //other letter's contribution actually unchanged, but it is easy to understand to iterate each letter and get the updated contribution value
            int current_contribution = 0;
            for (int j = 0; j < 26; j++) {
                current_contribution += contribution[j];
            }
            res += current_contribution;
            //at last update the last position contribution value in case the current letter shows up in the string again
            lastPositionContribution[cur - 'A'] = i + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        UniqueLetterString_LE_828 solution = new UniqueLetterString_LE_828();
        String S = "ABCBD";//27
        System.out.println(solution.uniqueLetterString(S));
    }
}
