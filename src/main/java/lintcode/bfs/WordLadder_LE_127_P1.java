package lintcode.bfs;

import java.util.*;

public class WordLadder_LE_127_P1 {
    /*
      - gut feeling is bfs, takes the wordList as a graph
      - Time is O(K*N^26) K is the number of words in the shortest path, N is the number of length of the word
      - Obviously the N^26 time can be optimized
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        int len = beginWord.length();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int path = 1;
        int curLevel = 1;
        int nextLevel = 0;

        while (queue.size() > 0) {
            String curString = queue.poll();
            curLevel--;
            for (int i = 0; i < len; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == curString.charAt(i)) {
                        continue;
                    }
                    StringBuilder sb = new StringBuilder(curString);
                    sb.setCharAt(i, c);
                    String nextStr = sb.toString();

                    if (nextStr.equals(endWord)) {
                        return path + 1;
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
                path++;
                curLevel = nextLevel;
                nextLevel = 0;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder_LE_127_P1 solution = new WordLadder_LE_127_P1();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        //expect 5

        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }
}
