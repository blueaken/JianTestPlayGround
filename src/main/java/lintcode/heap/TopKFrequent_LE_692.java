package lintcode.heap;

import java.util.*;
//import javafx.util.Pair;

public class TopKFrequent_LE_692 {
    /*
        - note the tricky is the input is String array, need to put into Pair class, then build the heap. If the input is int array, can put into heap directly.
        - also ref direct lambda expression https://leetcode.com/problems/top-k-frequent-words/discuss/2392696/PriorityQueue-Custom-Lambda-Comparator-or-Java-or-Easy-Solution
     */
//    public List<String> topKFrequent(String[] words, int k) {
//        Map<String, Integer> count = new HashMap<>();
//        for (String w : words) {
//            count.put(w, count.getOrDefault(w, 0) + 1);
//        }
//
//        //try lambda expression directly
//        PriorityQueue<Pair<String, Integer>> heap = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
//
//        for (String key : count.keySet()) {
//            heap.offer(new Pair(key, count.get(key)));
//        }
//
//        List<String> ret = new ArrayList<>();
//        for (int i = 0; i < k; i++) {
//            ret.add(heap.poll().getKey());
//        }
//        return ret;
//    }
//
//    public static void main(String[] args) {
//        TopKFrequent_LE_692 solution = new TopKFrequent_LE_692();
//        String[] words = {"i","love","leetcode","i","love","coding"};
//        int k = 2;
//        System.out.println(solution.topKFrequent(words, k));
//    }
}
