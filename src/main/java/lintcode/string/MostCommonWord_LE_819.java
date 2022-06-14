package lintcode.string;

import java.util.*;

public class MostCommonWord_LE_819 {
    /*
        Note - it is tricky that the paragraph is not separated by space but by punctuations, should ask interviewer before coding
        so - either replace all non-letter characters into space first, or process the whole paragraph string in one pass. We try the process of the whole paragraph way.

        Time Complexity: O(N+M).
        - We traverse each character in the input string once and only once. At each iteration, it takes constant time to perform the operations, except the operation that we build a new string out of the buffer. Excluding the cost of string-building out of the iteration, we can consider the cost of iterations as O(N).
        - If we combine all the string-building operations all together, in total it would take another O(N) time.
        - In addition, we built a set out of the list of banned words, which would take O(M) time.
        Hence, the overall time complexity of the algorithm is O(N) + O(N) + O(M) =O(N+M).

        Space Complexity: O(N+M).
        - We built a hashmap to count the frequency of each unique word, whose space would be of O(N).
        - Similarly, we built a set out of the banned word list, which would consume additional O(M) space.
        Therefore, the overall space complexity of the algorithm is O(N+M).
    */
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> bannedSet = new HashSet(Arrays.asList(banned));

        StringBuilder wordBuffer = new StringBuilder();
        int maxCount = 0;
        String maxKey = "";
        for (int i = 0; i < paragraph.length(); i++) {
            char cur = paragraph.charAt(i);
            // 1). consume the characters in a word
            if (Character.isLetter(cur)) {
                wordBuffer.append(Character.toLowerCase(cur));
                if (i != paragraph.length() - 1) {
                    continue;
                }
            }

            // 2). at the end of one word or at the end of paragraph
            if (wordBuffer.length() > 0) {
                String word = wordBuffer.toString();
                // identify the maximum count while updating the hashmap.
                if (!bannedSet.contains(word)) {
                    int newCount = map.getOrDefault(word, 0) + 1;
                    if (newCount > maxCount) {
                        maxCount = newCount;
                        maxKey = word;
                    }
                    map.put(word, newCount);
                }
            }
            // reset the buffer for the next word
            wordBuffer = new StringBuilder();
        }

        return maxKey;
    }

    public static void main(String[] args) {
        MostCommonWord_LE_819 solution = new MostCommonWord_LE_819();
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//        String[] banned = {"hit"};

        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};

        System.out.println(solution.mostCommonWord(paragraph, banned));
    }
}
