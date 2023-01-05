package lintcode.heap.labuladong;

import java.util.PriorityQueue;

public class SortCharactersByFrequency_LE_451 {
    /**
     1.4.2023
     try with PriorityQueue
     */
    public String frequencySort(String s) {
        int[][] freq = new int[128][2];
        for (char c : s.toCharArray()) {
            int curFreq = freq[c][1];
            freq[c] = new int[] {c, curFreq+1};
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            // if same frequency then sort in the order of dictinary
            int diff = b[1] - a[1];
            if (diff == 0) {
                diff = a[0] - b[0];
            }
            return diff;
        });
        for (char c : s.toCharArray()) {
            heap.offer(freq[c]);
        }

        StringBuilder sb = new StringBuilder();
        while (heap.size() > 0) {
            int[] cur = heap.poll();
            sb.append((char)cur[0]);
        }
        return sb.toString();
    }
}
