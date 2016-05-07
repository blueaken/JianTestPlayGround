package ninechapter_algorithm.chapter9_graphic.wordladder;

import java.util.*;

/**
 * Author: blueaken
 * Date: 5/6/16 09:24
 */
public class Solution {
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */

    public static int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null || dict.size() == 0
                || start == null || start.length() == 0
                || end == null || end.length() == 0) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int level = 1;
        int curLevel = 1;
        int nextLevel = 0;
        while (queue.size() > 0) {
            String cur = queue.poll();
            curLevel--;
            for (int i = 0; i < cur.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (cur.charAt(i) == c) {
                        continue;
                    }
                    StringBuilder sb = new StringBuilder(cur);
                    sb.setCharAt(i, c);
                    String temp = sb.toString();
                    if (temp.equals(end)) {
                        return level + 1;
                    }
                    if (dict.contains(temp) && !visited.contains(temp)) {
                        queue.offer(temp);
                        visited.add(temp);
                        nextLevel++;
                    }
                }
            }
            if (curLevel == 0) {
                curLevel = nextLevel;
                nextLevel = 0;
                level++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        //expect 2
//        String start = "a";
//        String end = "c";
//        Set<String> dict = new HashSet<>(Arrays.asList("a", "b", "c"));

//        //expect 5
//        String start = "hit";
//        String end = "cog";
//        Set<String> dict = new HashSet<>(Arrays.asList("hot","dot","dog","lot","log"));

        //expect 12
        //"kite - kits - kids - aids - ands - ants - ante - anne - acne - ache - achy - ashy"
        String start = "kite";
        String end = "ashy";
        Set<String> dict = new HashSet<>(Arrays.asList("ante","does","jive","achy","kids","kits","cart","ache","ands","ashe","acne","aunt","aids","kite","ants","anne","ashy"));

        System.out.println(ladderLength(start, end, dict));
    }
}
