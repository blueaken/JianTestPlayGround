package lintcode.graph;

import java.util.*;

public class AlienDictionary_LE_269 {
    /*
        - ref https://www.youtube.com/watch?v=yfGJFDkyEmE
        - 1st find the directed edges from words dictionary, then topological sort via BFS
    */
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        //init indegree & graph map
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!indegree.containsKey(c)) {
                    indegree.put(c, 0);
                    graph.put(c, new ArrayList<>());
                }
            }
        }

        //build graph and indegree map
        for (int i = 0; i < words.length - 1; i++) {
            String s = words[i];
            String t = words[i+1];
            int lenS = s.length();
            int lenT = t.length();

            //see if invalid case like ["abc", "ab"]
            if (lenS > lenT && s.substring(0, lenT).equals(t)) {
                return "";
            }

            for (int j = 0; j < Math.min(lenS, lenT); j++) {
                if (s.charAt(j) == t.charAt(j)) {
                    continue;
                }

                char u = s.charAt(j);
                char v = t.charAt(j);

                // //avoid duplicate edge
                // if (!graph.get(u).contains(v)) {
                //     //direction is from small to big
                //     graph.get(u).add(v);
                //     indegree.put(v, indegree.get(v) + 1);
                // }
                // //note break need to put outside the previous if block
                // break;

                //can skip duplicate edge decision to save time performance
                graph.get(u).add(v);
                indegree.put(v, indegree.get(v) + 1);
                break;
            }
        }

        //bfs topological sort
        Deque<Character> queue = new ArrayDeque<>();
        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offerFirst(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (queue.size() > 0) {
            Character cur = queue.pollLast();
            sb.append(cur);

            for (Character neigh : graph.get(cur)) {
                indegree.put(neigh, indegree.get(neigh) - 1);
                if (indegree.get(neigh) == 0) {
                    queue.offerFirst(neigh);
                }
            }
        }

        if (sb.length() != indegree.size()) {
            return "";
        } else {
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        AlienDictionary_LE_269 solution = new AlienDictionary_LE_269();
        String[] words = {"wrt","wrf","er","ett","rftt","te"};//"wertf"
        System.out.println(solution.alienOrder(words));
    }
}
