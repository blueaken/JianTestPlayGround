package lintcode.heap;

import java.util.*;

public class TopKFrequent_1281 {
    /**
     * @param nums: the given array
     * @param k: the given k
     * @return: the k most frequent elements
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        if (nums.length < k) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        Queue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return map.get(i1) - map.get(i2);
            }
        });

        for (int i : set) {
            heap.offer(i);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        Iterator<Integer> iterator = heap.iterator();
        while (iterator.hasNext()) {
            res.add(iterator.next());
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        TopKFrequent_1281 solution = new TopKFrequent_1281();
        System.out.println(solution.topKFrequent(nums, k));
    }
}
