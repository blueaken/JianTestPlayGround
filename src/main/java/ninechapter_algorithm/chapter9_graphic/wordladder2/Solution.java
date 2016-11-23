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
        if (dict == null) {
            return result;
        }

        dict.add(start);
        dict.add(end);
        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> lastVisited = new HashMap<>();

        //build distance and lastVisited info table
        bfs(distance, start, dict, lastVisited);
        //find all paths
        dfs(result, distance, lastVisited, end, start, new ArrayList<String>());
        return result;
    }

    private void dfs(List<List<String>> result, Map<String, Integer> distance,
                     Map<String, List<String>> lastVisited, String cur, String start, List<String> path) {
        path.add(cur);
        if (cur.equals(start)) {
            Collections.reverse(path);
            result.add(new ArrayList<>(path));
            Collections.reverse(path);
        }
        for (String next : lastVisited.get(cur)) {
            if (distance.get(cur) == distance.get(next) + 1) {
                dfs(result, distance, lastVisited, next, start, path);
            }
        }
        path.remove(path.size() - 1);
    }

    private void bfs(Map<String, Integer> distance,
                     String start, Set<String> dict, Map<String, List<String>> lastVisited) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);
        for (String s : dict) {
            lastVisited.put(s, new ArrayList<String>());
        }

        while (queue.size() > 0) {
            String cur = queue.poll();
            for (String candidate : getNeighbors(cur, dict)) {
                //note: add all cur's neighbors into lastVisited
                lastVisited.get(cur).add(candidate);
                if (!distance.containsKey(candidate)) {
                    queue.offer(candidate);
                    distance.put(candidate, distance.get(cur) + 1);
                }
            }
        }
    }

    private List<String> getNeighbors(String cur, Set<String> dict) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < cur.length(); i++) {
            StringBuilder sb = new StringBuilder(cur);
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == cur.charAt(i)) {
                    continue;
                }
                sb.setCharAt(i, c);
                String candidate = sb.toString();
                if (dict.contains(candidate)) {
                    result.add(candidate);
                }
            }
        }
        return result;
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
