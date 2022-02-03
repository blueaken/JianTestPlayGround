package lintcode.heap;

import java.util.*;

public class FrequencySort_1233 {
    /**
     * @param s:
     * @return: return a string
     */
    //Idea: 通过Heap, 根据字母出现的频率和字典顺序这2个参数进行排序
    public String frequencySort(String s) {
        // write your code here
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        Queue<Character> minHeap = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare (Character c1, Character c2) {
                int f1 = map.get(c1);
                int f2 = map.get(c2);
                int diff = f2 - f1;
                if (diff == 0) {
                    diff = c1 - c2;
                }
                return diff;
            }
        });

        for (int i = 0; i < s.length(); i++) {
            minHeap.offer(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while (minHeap.size() > 0) {
            sb.append(minHeap.poll());
        }
        return sb.toString();
    }
}
