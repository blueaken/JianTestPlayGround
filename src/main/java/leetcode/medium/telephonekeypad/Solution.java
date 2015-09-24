package leetcode.medium.telephonekeypad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 9/21/15 8:08 PM
 */
public class Solution {
    // 1 => a, b, c
    // 2 => d, e ,f
    // 3 => h, i, j
    //
    //..0

    // 1, 2 => ad, ae, af, bd, be, bf, cd, ce, cf

    private static final Map<Integer, String> DICTIONARY = new HashMap<Integer, String>() {
        {
            put(1, "abc");
            put(2, "def");
            put(3, "ghi");
        }
    };

    public static List<String> getTexts(List<Integer> numbers) {
        List<String> res = new ArrayList<String>();
        List<String> preres = new ArrayList<String>();
        res.add("");

        for (int i = 0; i < numbers.size(); i++) {
            for (String str : res) {
                String letters = DICTIONARY.get(numbers.get(i));
                for (int j = 0; j < letters.length(); j++)
                    preres.add(str + letters.charAt(j));
            }
            res = preres;
            preres = new ArrayList<String>();
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        System.out.println(getTexts(numbers));
    }

}
