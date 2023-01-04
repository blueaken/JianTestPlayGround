package lintcode.heap.labuladong;

public class UglyNumberII_LE_264_DP {
    /**
     1.4.2022
     - 微软系题目
     - 对于当前ugly number的某一个元素k，由它可以生成另外三个ugly number，分别是k*2,k*3,k*5，于是将这三个数添加进一个小顶堆的优先队列，自动冒出候选者中的最小值。注意需要做去重。因为每次弹出一个数，会加入三个数，这样的时间复杂度是o(3Nlog3N).
     - ref 管哥 post
     - 另有DP解法更高效，就是东哥post上解法
     -----------------------------------------
     - try DP解法 ref东哥 post，可以看成3个虚拟链表的合并；避免了重复数的添加，更高效 O(N)
     =========================================
     */
    public int nthUglyNumber(int n) {
        // 可以理解为三个指向有序链表头结点的指针
        int p2 = 1, p3 = 1, p5 = 1;
        // 可以理解为三个有序链表的头节点的值
        int product2 = 1, product3 = 1, product5 = 1;
        // 可以理解为最终合并的有序链表（结果链表）或者dp[]结果数组
        int[] ugly = new int[n+1];
        // 可以理解为结果链表上的指针
        int p = 1;

        while (p <= n) {
            int min = Math.min(Math.min(product2, product3), product5);
            ugly[p] = min;
            p++;

            if (min == product2) {
                // 体会一下不是 2 * min, 而是 2 * ugly[p2]
                product2 = 2 * ugly[p2];
                p2++;
            }
            if (min == product3) {
                product3 = 3 * ugly[p3];
                p3++;
            }
            if (min == product5) {
                product5 = 5 * ugly[p5];
                p5++;
            }
        }

        return ugly[n];
    }
}
