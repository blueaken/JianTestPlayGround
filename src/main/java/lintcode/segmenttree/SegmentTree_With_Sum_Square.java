package lintcode.segmenttree;


import java.util.Arrays;

public class SegmentTree_With_Sum_Square {
    public static int MOD = (int)1e9+7;

    public long[] sum;
    public long[] sqr;
    public long[] lazyTree;

    SegmentTree_With_Sum_Square(int[] arr) {
        int n = arr.length;
        int height = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        //Maximum size of the tree
        int maxSize = 2 * (int) Math.pow(2, height) - 1;

        sum = new long[maxSize];
        sqr = new long[maxSize];
        lazyTree = new long[maxSize];
        build(0, n-1, 0, arr);
    }

    void build(int left, int right, int index, int[] arr) {
        // base case - hit a leaf node
        if (left == right) {
            sum[index] = arr[left];
            sqr[index] = arr[left] * arr[left] % MOD;
            return;
        }
        int mid = left + ((right - left) >> 1);
        build(left, mid, index*2+1, arr);
        build(mid+1, right, index*2+2, arr);

        // post traverse handling, similar to merge sort
        sum[index] = (sum[index*2+1] + sum[index*2+2]) % MOD;
        sqr[index] = (sqr[index*2+1] + sqr[index*2+2]) % MOD;
    }

    void rangeUpdate(int x, int y, int updateVal, int left, int right, int index) {
        updateLazy(left, right, index);

        // base case - if the input range has no overlap with current node, do nothing
        if (x > right || y < left) {
            return;
        }
        // base case - if the input range is completely overlap with current node, update the current node val via lazy propagation method
        if (x <= left && right <= y) {
            lazyTree[index] = updateVal;
            updateLazy(left, right, index);
            return;
        }

        // if half overlap then query the left & right child
        int mid = left + ((right - left) >> 1);
        rangeUpdate(x, y, updateVal, left, mid, index*2+1);
        rangeUpdate(x, y,updateVal, mid+1, right, index*2+2);

        // in case child nodes val updated
        sum[index] = (sum[index*2+1] + sum[index*2+2]) % MOD;
        sqr[index] = (sqr[index*2+1] + sqr[index*2+2]) % MOD;
    }

    void updateLazy(int left, int right, int index) {
        if (left != right) {
            lazyTree[index*2+1] += lazyTree[index];
            lazyTree[index*2+2] += lazyTree[index];
        }

        long gap = right - left + 1;
        long newSum = sum[index] + gap * lazyTree[index];
        long newSqr = sqr[index] + 2 * lazyTree[index] * sum[index] + lazyTree[index] * lazyTree[index] * gap;

        sum[index] = newSum % MOD;
        sqr[index] = newSqr % MOD;

        lazyTree[index] = 0;
    }

    void addOne(int x, int y, int left, int right, int index) {
        updateLazy(left, right, index);

        // base case - if the input range has no overlap with current node, do nothing
        if (x > right || y < left) {
            return;
        }
        // base case - if the input range is completely overlap with current node, update the current node val via lazy propagation method
        if (x <= left && right <= y) {
            lazyTree[index] = 1;
            updateLazy(left, right, index);
            return;
        }

        // if half overlap then update the left & right child
        int mid = left + ((right - left) >> 1);
        addOne(x, y, left, mid, index*2+1);
        addOne(x, y, mid+1, right, index*2+2);

        // in case child nodes val updated
        sum[index] = (sum[index*2+1] + sum[index*2+2]) % MOD;
        sqr[index] = (sqr[index*2+1] + sqr[index*2+2]) % MOD;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};

        int n = nums.length;
        int[] freq = new int[n];
        int[] lastSeen = new int[100001];
        Arrays.fill(lastSeen, -1);

        long ans = 0;
        SegmentTree_With_Sum_Square solution = new SegmentTree_With_Sum_Square(freq);

        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            int start = lastSeen[cur] + 1;
            int end = i;

            lastSeen[cur] = i;

            // update 1 count to the element between [lastSeen+1 .. i]
            solution.rangeUpdate(start, end, 1, 0, n-1, 0);
//            solution.addOne(start, end, 0, n-1, 0);
            ans = (ans + solution.sqr[0]) % MOD;
        }

        System.out.println(ans);

    }
}
