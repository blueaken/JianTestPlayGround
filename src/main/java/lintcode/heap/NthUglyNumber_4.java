package lintcode.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class NthUglyNumber_4 {
    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    //Idea: 很容易想到按顺序一个个试，但当n很大时，效率很低，测试超时。尝试使用Heap来处理，一次生成3个新丑数，并需要检查是否已经生成过。
    //Ref: https://www.lintcode.com/problem/4/solution/16717
    public int nthUglyNumber(int n) {
        // write your code here
        //Java use PriorityQueue as Heap，by default is MinHeap
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();
        int[] factors = {2,3,5};

        heap.offer(1L);
        visited.add(1L);
        long cur = 1;

        for (int i = 1; i <= n; i++) {
            cur = heap.poll();
            for (int f : factors) {
                long tmp = cur * f;
                if (!visited.contains(tmp)) {
                    heap.offer(tmp);
                    visited.add(tmp);
                }
            }
        }

        return (int)cur;
    }

    // public int nthUglyNumber(int n) {
    //     // write your code here
    //     int count = 0;
    //     int res = 0;
    //     while (count < n) {
    //         res++;
    //         if (isUglyNum(res)) {
    //             count++;
    //         }
    //     }
    //     return res;
    // }

    // private boolean isUglyNum(int num) {
    //     if (num == 1) {
    //         return true;
    //     }
    //     while (num >= 5 && num % 5 == 0) {
    //         num /= 5;
    //     }
    //     while (num >= 3 && num % 3 == 0) {
    //         num /= 3;
    //     }
    //     while (num >= 2 && num % 2 == 0) {
    //         num /= 2;
    //     }
    //     return num == 1;
    // }

    public static void main(String[] args) {
        int n = 7;

        NthUglyNumber_4 solution = new NthUglyNumber_4();
        System.out.println(solution.nthUglyNumber(n));
    }
}
