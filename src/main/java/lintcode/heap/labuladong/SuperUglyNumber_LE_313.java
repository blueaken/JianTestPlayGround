package lintcode.heap.labuladong;

import java.util.PriorityQueue;

public class SuperUglyNumber_LE_313 {
    /**
     1.4.2023
     similar to 264, 把每个质因数看成一个有序链表，本题不止3个质因数，用heap来帮助排序筛选
     ref东哥post
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        // 优先队列中装三元组 int[] {product, prime, pi}
        // 其中 product 代表链表节点的值，prime 是计算下一个节点所需的质数因子，pi 代表链表上的指针
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // init虚拟链表值
        for (int i = 0; i < primes.length; i++) {
            heap.offer(new int[] {1, primes[i], 1});
        }

        int[] ugly = new int[n+1];
        // 可以理解为结果链表上的指针
        int p = 1;
        while (p <= n) {
            int[] cur = heap.poll();
            int product = cur[0];
            int prime = cur[1];
            int index = cur[2];

            // 注意去重
            if (product != ugly[p-1]) {
                ugly[p] = product;
                p++;
            }

            // similar to 264, 体会一下不是 prime * product 而是 prime * ugly[index]
            heap.offer(new int[] {prime * ugly[index], prime, index+1});
        }

        return ugly[n];
    }
}
