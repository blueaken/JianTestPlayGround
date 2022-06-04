package lintcode.bfs;

import java.util.*;

public class WordLadder_LE_127 {
    //try bfs, take the wordList as a graph
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int len = 1;
        int curLevel = 1, nextLevel = 0;
        while (queue.size() > 0) {
            String curStr = queue.poll();
            curLevel--;

            for (int i = 0; i < beginWord.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == curStr.charAt(i)) {
                        continue;
                    }

                    StringBuilder sb = new StringBuilder(curStr);
                    sb.setCharAt(i, c);
                    String nextStr = sb.toString();

                    if (nextStr.equals(endWord)) {
                        return len + 1;
                    }
                    if (!wordList.contains(nextStr) || visited.contains(nextStr)) {
                        continue;
                    }
                    queue.offer(nextStr);
                    visited.add(nextStr);
                    nextLevel++;
                }
            }

            if (curLevel == 0) {
                len++;
                curLevel = nextLevel;
                nextLevel = 0;
            }
        }
        //no match
        return 0;
    }

    public static void main(String[] args) {
        WordLadder_LE_127 solution = new WordLadder_LE_127();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        //expect 5

        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }
}
