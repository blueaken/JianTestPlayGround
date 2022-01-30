package lintcode.heap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

 class Record {
      public int id, score;
      public Record(int id, int score){
          this.id = id;
          this.score = score;
      }
  }

public class HighFive_613 {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        int size = 5;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(size);
        for (Record rec : results) {
            if (map.keySet().contains(rec.id)) {
                minHeap = map.get(rec.id);
                minHeap.offer(rec.score);
                if (minHeap.size() > size) {
                    minHeap.poll();
                }
                map.put(rec.id, minHeap);
            } else {
                minHeap = new PriorityQueue<>(size);
                minHeap.offer(rec.score);
                map.put(rec.id, minHeap);
            }
        }

        Map<Integer, Double> res = new HashMap<>();
        for (Integer id : map.keySet()) {
            minHeap = map.get(id);
            Double sum = 0.0;
            Iterator<Integer> iterator = minHeap.iterator();
            while (iterator.hasNext()) {
                sum += iterator.next();
            }
            res.put(id, sum/minHeap.size());
        }
        return res;
    }

    public static void main(String[] args) {
        Record[] input = {new Record(1, 91), new Record(1, 92), new Record(2, 93), new Record(2, 78)};

        HighFive_613 solution = new HighFive_613();
        System.out.println(solution.highFive(input));
    }
}
