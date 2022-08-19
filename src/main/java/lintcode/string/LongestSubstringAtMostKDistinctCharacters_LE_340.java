package lintcode.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtMostKDistinctCharacters_LE_340 {
    /*
        ref https://www.youtube.com/watch?v=5Ec68Qr2GTM
        - sliding window
    */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int slow = 0;
        int ans = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            char end = s.charAt(fast);
            count.put(end, count.getOrDefault(end, 0) + 1);
            while (count.size() > k) {
                //slow pointer keep moving forward when out of bountray
                char start = s.charAt(slow);
                count.put(start, count.get(start) - 1);
                if (count.get(start) == 0) {
                    count.remove(start);
                }
                slow++;
            }
            ans = Math.max(ans, fast - slow + 1);
        }
        return ans;
    }
}
