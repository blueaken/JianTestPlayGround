package lintcode.others.count_subarray_by_element;

import java.util.HashSet;
import java.util.Set;

public class VowelsOfAllSubstrings_LE_2063 {
    /*
        - similar to 2262
        - contribution of each vowel char is (i + 1) * (n - i)
    */
    public long countVowels(String word) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        long ans = 0;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (set.contains(cur)) {
                ans += (long)(i + 1)*(word.length() - i);
            }
        }
        return ans;
    }
}
