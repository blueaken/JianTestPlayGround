package lintcode.string;

import java.util.*;

public class GroupAnagrams_LE_49_P2 {
    /*
        Idea: sort each string and get the anagram key, store it into a map and go through the string                   list.
              Time - O(NMLogM), which N is the length of string list, M is the max length of the string
              Space - O(NM), on worst case, the size of Map is same as the list.
        Ref - https://leetcode.com/problems/group-anagrams/solution/
        ==========================
        P2 - 10.28.2022
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keyToList = new HashMap<>();
        for (String str : strs) {
            //get key of each string
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);

            keyToList.putIfAbsent(key, new ArrayList<>());
            keyToList.get(key).add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for (String key : keyToList.keySet()) {
            res.add(keyToList.get(key));
        }
        return res;
    }
}
