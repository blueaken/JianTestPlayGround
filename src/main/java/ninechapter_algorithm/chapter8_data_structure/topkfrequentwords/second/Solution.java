package ninechapter_algorithm.chapter8_data_structure.topkfrequentwords.second;

import java.util.*;

class Element {
    String key;
    int freq;
    Element(String key, int freq) {
        this.key = key;
        this.freq = freq;
    }
}

public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        String[] result = new String[k];
        if (words == null || k < 1 || words.length < k) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        Comparator<Element> freqComparator = new Comparator<Element>() {
            @Override
            public int compare(Element a, Element b) {
                if (a.freq != b.freq){
                    return b.freq - a.freq;
                } else {
                    return a.key.compareTo(b.key);
                }
            }
        };
        PriorityQueue<Element> pq = new PriorityQueue<>(map.size(), freqComparator);
        for (String key : map.keySet()) {
            pq.add(new Element(key, map.get(key)));
        }

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().key;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] test = {"yes","lint","code","yes","code","baby","you","baby","chrome","safari","lint","code","body","lint","code"};
        int k = 4;

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequentWords(test, k)));
    }
}
