package ninechapter_algorithm.chapter8_data_structure.topkfrequentwords;

import java.util.*;

/**
 * Author: blueaken
 * Date: 5/3/16 19:19
 */

class Pair {
    String key;
    int value;

    Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class Solution {

    private static Comparator<Pair> pairComparator = new Comparator<Pair>() {
        @Override
        public int compare(Pair left, Pair right) {
            if (left.value != right.value) {
                return left.value - right.value;
            }
            return right.key.compareTo(left.key);
        }
    };

    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    public static String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        String[] result = new String[k];
        if (words == null || words.length == 0 || k == 0) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }

        Queue<Pair> heap = new PriorityQueue<>(k, pairComparator);
        for (String word : map.keySet()) {
            Pair newPair = new Pair(word, map.get(word));
            if (heap.size() < k) {
                heap.add(newPair);
            } else if (pairComparator.compare(newPair, heap.peek()) > 0) {
                heap.poll();
                heap.add(new Pair(word, map.get(word)));
            }
        }

        //reverse order
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = heap.poll().key;
        }
        return result;
    }

    public static void main(String[] args) {
//        String[] test = {"yes","lint","code","yes","code","baby","you","baby","chrome","safari","lint","code","body",
//                "lint","code"};
//        int k = 3;

        String[] test = {"a","b","c","a","c"};
        int k = 1;

        System.out.println(Arrays.toString(topKFrequentWords(test, k)));
    }
}