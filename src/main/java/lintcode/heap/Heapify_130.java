package lintcode.heap;

import java.util.Arrays;

public class Heapify_130 {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    //Idea: 参考jiuzhang Video的讲义，
    //0. 可以直接排序，但是O(nlogn), 能否实现O(n)
    //1. 如果一个堆的左右子堆都是最小堆，那么根节点经过SinkDown之后，得到的堆也是最小堆
    //2. 对一个堆数组 (n-2)/2对应的是最后一个元素的父节点，从这个节点开始向前对每一个节点进行SinkDown，最后得到一个
    //完整的堆。
    //时间复杂度是n/2 + n/4 + n/8 + ... = n
    public void heapify(int[] A) {
        // write your code here
        int len = A.length;
        if (len < 2) {
            return;
        }

        for (int i = (len - 2) / 2; i >= 0; i--) {
            sinkDown(A, i);
        }
        return;
    }

    private void sinkDown (int[] A, int pos) {
        while (pos < A.length) {
            int left = 2 * pos + 1;
            int right = 2 * pos + 2;

            int smallest = pos;

            if (left < A.length && A[left] < A[smallest]) {
                smallest = left;
            }
            if (right < A.length && A[right] < A[smallest]) {
                smallest = right;
            }

            if (smallest == pos) {
                break;
            }

            swap(A, smallest, pos);
            pos = smallest;
        }
    }

    private void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

    public static void main(String[] args) {
        int[] input = {3,2,1,4,5};

        Heapify_130 solution = new Heapify_130();
        solution.heapify(input);
        System.out.println(Arrays.toString(input));
    }
}
