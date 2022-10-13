package lintcode.others.count_subarray_by_element;

import java.util.HashSet;
import java.util.Set;

public class VowelsOfAllSubstrings_LE_2063_P1 {
    /*
        - similar to 2262
        - contribution of each vowel char is (i + 1) * (n - i)
        ==================================
        P1 10.13.2022
        - ref prev notes
        - since there is no requirement to be distinct, contribution of each vowel is just (i+1)*(n-i)
    */
    public long countVowels(String word) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int n = word.length();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(word.charAt(i))) {
                ans += 1L * (i+1) * (n-i);
            }
        }
        return ans;
    }
}
