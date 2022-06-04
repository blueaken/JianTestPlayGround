package lintcode.bfs;

import java.util.*;

public class WordLadder_LE_127_Optimized {
    /*
      - gut feeling is bfs, takes the wordList as a graph
      - Time is O(K*N^26) K is the number of words in the shortest path, N is the number of length of the word
      - Obviously the N^26 time can be optimized
      - we can do a preprocessing work to find adjacent nodes efficiently
      - for each word in the dictionary, we make a generic form, dog -> *og, d*g, do*, and use it as a key to avoid iterate each 26 chars.
      - Time is O(K*N^2)
      - 1. to build the preprocessing dictionary, for each word need iterate N times, total is K * N. Additionally, each key takes O(N) because of the substring operation. Total adds up to O(K*N^2)
      - 2. the bfs part, worst case need iterate each word, which is O(K). And for each word iterate each position, which is O(N), plus O(N) cost for the substring operation to form the key. Total adds up to O(K*N^2).
      - Sum up the above 2 together, the total time is O(K*N^2)
      - Space is O(K*N^2)
      - 1. for the dictionary, for each word need N generic formation keys, note for each key we store the original word of length N. That means for each word, need O(N^2) space, and total is O(K*N^2) space.
      - 2. visited set takes K*N space.
      - 3. queue for each word takes N length, total is O(K*N).
      - Sum up the above 3 together, total space is O(K*N^2).
      - Space can be further optimized, as only the index need be saved in the dictionary instead of the original word, which is O(K*N).
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        //preprocessing the dictionary
        int len = beginWord.length();
        Map<String, List<String>> dictionary = new HashMap<>(); //generic key, list of words from input list
        for (String word : wordList) {
            for (int i = 0; i < len; i++) {
                String key = word.substring(0, i) + "*" + word.substring(i+1, len);
                List<String> list = dictionary.getOrDefault(key, new ArrayList());
                list.add(word);
                dictionary.put(key, list);
            }
        }

        //bfs
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int num = 1;
        int curLevel = 1, nextLevel = 0;
        while (queue.size() > 0) {
            String curWord = queue.poll();
            curLevel--;

            for (int i = 0; i < len; i++) {
                String curKey = curWord.substring(0, i) + "*" + curWord.substring(i+1, len);
                if (dictionary.containsKey(curKey)) {
                    for (String adjacentNode : dictionary.get(curKey)) {
                        if (adjacentNode.equals(endWord)) {
                            return (num + 1);
                        }
                        if (!visited.contains(adjacentNode)) {
                            queue.offer(adjacentNode);
                            visited.add(adjacentNode);
                            nextLevel++;
                        }
                    }
                }
            }

            if (curLevel == 0) {
                num++;
                curLevel = nextLevel;
                nextLevel = 0;
            }
        }
        //no match
        return 0;
    }
}
