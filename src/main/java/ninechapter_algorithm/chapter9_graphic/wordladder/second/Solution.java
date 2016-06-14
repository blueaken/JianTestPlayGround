package ninechapter_algorithm.chapter9_graphic.wordladder.second;

import java.util.*;

/**
 * Author: blueaken
 * Date: 6/14/16 10:07
 */
public class Solution {
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start == null || end == null || dict == null || dict.size() == 0) {
            return 0;
        }
        if (start.equals(end)) {
            return 1;
        }

        int len = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        int curLevel = 1;
        int nextLevel = 0;

        while (queue.size() > 0) {
            String cur = queue.poll();
            curLevel--;
            for (int i = 0; i < cur.length(); i++) {
                char curChar = cur.charAt(i);
                StringBuilder temp = new StringBuilder(cur);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == curChar) {
                        continue;
                    }
                    temp.setCharAt(i, c);
                    String candidate = temp.toString();
                    if (candidate.equals(end)) {
                        return len + 1;
                    } else if (dict.contains(candidate) &&
                            !visited.contains(candidate)) {
                        queue.offer(candidate);
                        visited.add(candidate);
                        nextLevel++;
                    }
                }
            }

            if (curLevel == 0) {
                curLevel = nextLevel;
                nextLevel = 0;
                len++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //expect 2
//        String start = "a";
//        String end = "c";
//        Set<String> dict = new HashSet<>(Arrays.asList("a", "b", "c"));

        //expect 1
        String start = "a";
        String end = "a";
        Set<String> dict = new HashSet<>(Arrays.asList("b"));

//        //expect 5
//        String start = "hit";
//        String end = "cog";
//        Set<String> dict = new HashSet<>(Arrays.asList("hot","dot","dog","lot","log"));

        //expect 12
        //"kite - kits - kids - aids - ands - ants - ante - anne - acne - ache - achy - ashy"
//        String start = "kite";
//        String end = "ashy";
//        Set<String> dict = new HashSet<>(Arrays.asList("ante", "does", "jive", "achy", "kids", "kits", "cart", "ache", "ands", "ashe", "acne", "aunt", "aids", "kite", "ants", "anne", "ashy"));

        System.out.println(solution.ladderLength(start, end, dict));
    }
}
