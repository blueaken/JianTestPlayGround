package ninechapter_algorithm.chapter9_graphic.wordladder2;

import java.util.*;

/**
 * Author: blueaken
 * Date: 5/6/16 15:44
 */
public class Solution {
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (dict == null || dict.size() == 0
                || start == null || start.length() == 0
                || end == null || end.length() == 0) {
            return result;
        }
        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> lastVisited = new HashMap<>();

        dict.add(start);
        dict.add(end);
        distance.put(start, 0);
        for (String s : dict) {
            lastVisited.put(s, new ArrayList<String>());
        }

        bfs(distance, lastVisited, dict, start);
        List<String> path = new ArrayList<>();
        dfs(result, path, distance, lastVisited, end, start);

        return result;
    }

    private void dfs(List<List<String>> result, List<String> path, Map<String, Integer> distance,
                     Map<String, List<String>> lastVisited, String cur, String start) {
        path.add(cur);
        if (cur.equals(start)) {
            Collections.reverse(path);
            result.add(new ArrayList<>(path));
            Collections.reverse(path);
        } else {
            for (String next : lastVisited.get(cur)) {
                if (distance.containsKey(next) && distance.get(cur) == distance.get(next) + 1) {
                    dfs(result, path, distance, lastVisited, next, start);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    private void bfs(Map<String, Integer> distance, Map<String, List<String>> lastVisited,
                     Set<String> dict, String start) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);

        while (queue.size() > 0) {
            String cur = queue.poll();
            List<String> nextList = expand(cur, dict, distance);
            for (String next : nextList) {
                lastVisited.get(next).add(cur);
                if (!distance.containsKey(next))  {
                    queue.offer(next);
                    distance.put(next, distance.get(cur) + 1);
                }
            }
        }
    }

    private List<String> expand(String cur, Set<String> dict, Map<String, Integer> distance) {
        List<String> nextList = new ArrayList<>();
        for (int i = 0; i < cur.length(); i++) {
            StringBuilder sb = new StringBuilder(cur);
            for (char c = 'a'; c <= 'z'; c++) {
                if (cur.charAt(i) != c) {
                    sb.setCharAt(i, c);
                    String temp = sb.toString();
                    if (dict.contains(temp)) {
                        nextList.add(temp);
                    }
                }
            }
        }
        return nextList;
    }

    public static void main(String[] args) {
        //expect [["a","c"]]
//        String start = "a";
//        String end = "c";
//        Set<String> dict = new HashSet<>(Arrays.asList("a", "b", "c"));

        /*
        expect
            [
                ["hit","hot","dot","dog","cog"],
                ["hit","hot","lot","log","cog"]
            ]
         */
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<>(Arrays.asList("hot","dot","dog","lot","log"));

        Solution solution = new Solution();
        System.out.println(solution.findLadders(start, end, dict));
    }
}
