package lintcode.twopointers;

import java.util.HashSet;
import java.util.Set;

public class FindSubstring_1377 {
    /**
     * @param str: The string
     * @param k: The length of the substring
     * @return: The answer
     */
    //Idea: 同向双指针
    //Note: SubString中不能有相同字符
    public int findSubstring(String str, int k) {
        // Write your code here
        if (str == null || str.length() < k) {
            return 0;
        }

        Set<String> res = new HashSet<>();
        for (int i = 0; i < str.length() - k + 1; i++) {
            StringBuilder sb = new StringBuilder();
            Set<Character> cSet = new HashSet<>();
            int j = i;
            while (j < k + i) {
                if (!cSet.contains(str.charAt(j))) {
                    cSet.add(str.charAt(j));
                    sb.append(str.charAt(j));
                } else {
                    break;
                }
                j++;
            }
            if (j == k + i) {
                res.add(sb.toString());
            }
        }
        return res.size();
    }

    public static void main(String[] args) {
        String input = "abbabcb";
        int k = 3;

        FindSubstring_1377 solution = new FindSubstring_1377();
        System.out.println(solution.findSubstring(input, k));
    }
}
