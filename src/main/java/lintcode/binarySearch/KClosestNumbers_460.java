package lintcode.binarySearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestNumbers_460 {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    //Idea: 先用BS找到closest index, 再从2边分别加入设置好比较逻辑的heap, 使用heap可以简化代码
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        if (k < 0) {
            return new int[1];
        }

        Queue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare (Integer i1, Integer i2) {
                int diff = Math.abs(i1 - target) - Math.abs(i2 - target);
                if (diff == 0) {
                    return i1 - i2;
                }
                return diff;
            }
        });

        int start = 0, end = A.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        minHeap.offer(A[start]);
        //左面加k个元素
        int pos = start - 1, count = k;
        while (pos >= 0 && count >= 0) {
            minHeap.offer(A[pos--]);
            count--;
        }
        //右面加k个元素
        pos = start + 1;
        count = k;
        while (pos < A.length && count >= 0) {
            minHeap.offer(A[pos++]);
            count--;
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3};
        int target = 2;
        int k = 3;

        KClosestNumbers_460 solution = new KClosestNumbers_460();
        System.out.println(Arrays.toString(solution.kClosestNumbers(input, target, k)));
    }
}
