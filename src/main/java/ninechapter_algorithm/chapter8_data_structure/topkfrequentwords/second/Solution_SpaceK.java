package ninechapter_algorithm.chapter8_data_structure.topkfrequentwords.second;

import java.util.*;

/**
 * Author: blueaken
 * Date: 6/7/16 09:53
 */

public class Solution_SpaceK {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if (words == null || words.length < k) {
            return null;
        }
        String[] res = new String[k];

        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        Comparator<Element> comparator = new Comparator<Element>() {
            @Override
            public int compare (Element a, Element b) {
                if (a.freq != b.freq) {
                    return a.freq - b.freq;
                }
                return b.key.compareTo(a.key);
            }
        };
        Queue<Element> heap = new PriorityQueue<>(k, comparator);
        for (String s : map.keySet()) {
            Element cur = new Element(s, map.get(s));
            if (heap.size() < k) {
                heap.add(cur);
            } else if (comparator.compare(cur, heap.peek()) > 0) {
                heap.poll();
                heap.add(cur);
            }
        }

        //reverse order in output
        for (int i = k - 1; i >= 0; i--) {
            res[i] = heap.poll().key;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] test = {"yes","lint","code","yes","code","baby","you","baby","chrome","safari","lint","code","body","lint","code"};
        int k = 4;

        Solution_SpaceK solution = new Solution_SpaceK();
        System.out.println(Arrays.toString(solution.topKFrequentWords(test, k)));
    }
}
