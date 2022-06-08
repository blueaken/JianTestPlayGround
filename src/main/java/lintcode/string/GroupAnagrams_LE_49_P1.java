package lintcode.string;

import java.util.*;

public class GroupAnagrams_LE_49_P1 {
    /*
        Idea: sort each string and get the anagram key, store it into a map and go through the string                   list.
              Time - O(NMLogM), which N is the length of string list, M is the max length of the string
              Space - O(NM), on worst case, the size of Map is same as the list.
        Ref - https://leetcode.com/problems/group-anagrams/solution/
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(); //key, List String
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    public static void main(String[] args) {
        GroupAnagrams_LE_49_P1 solution = new GroupAnagrams_LE_49_P1();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        //[[eat, tea, ate], [bat], [tan, nat]]

        System.out.println(solution.groupAnagrams(strs));
    }
}
