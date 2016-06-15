package ninechapter_algorithm.chapter9_graphic.optional.stringpermutation2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 6/15/16 09:33
 */
public class Solution {
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        // Write your code here
        List<String> result = new ArrayList<>();
        if (str == null) {
            return result;
        }

        char[] sorted = str.toCharArray();
        Arrays.sort(sorted);

        boolean[] visited = new boolean[sorted.length];
        rec(result, sorted, new StringBuilder(), visited);
        return result;
    }

    private void rec(List<String> result, char[] sorted, StringBuilder sb,
                     boolean[] visited) {
        if (sb.length() == sorted.length) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < sorted.length; i++) {
            if (visited[i]
                    || i != 0 && sorted[i] == sorted[i - 1] && visited[i - 1]) {
                continue;
            }
            sb.append(sorted[i]);
            visited[i] = true;
            rec(result, sorted, sb, visited);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //String test = "abb";
        String test = "abcdefghijk";

        System.out.println(solution.stringPermutation2(test));
    }
}
