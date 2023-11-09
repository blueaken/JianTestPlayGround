package lintcode.segmenttree;

import java.util.*;
public class MaxBalancedSubsequenceSum_LE_2926 {
    /**
     11.06.23
     - ref CodingMohan's video 1st 10 mins, come up a top down dp solution
     - https://www.youtube.com/watch?v=W04cD_iFvfU
     - Time is O(N^2), TLE @ 341/345
     ======================================
     11.08.23
     - ref the rest part of Coding Mohan's video and solve it with Segment Tree
     - Time now is O(NLogN)
     - https://leetcode.com/problems/maximum-balanced-subsequence-sum/solutions/4251463/segment-tree-discretization/
     ======================================
     Dry Run Example -
     ori:
     0 1 2 3 4 5 6 7 8 9
     --------------------
     5,6,8,9,7,8,6,7,4,2

     converted:
     0 1 2 3 4 5 6 7  8  9
     ---------------------
     5,5,6,6,3,3,0,0,-4,-7

     sort by converted value:
     9  8 6 7 4 5 0 1 2 3
     ---------------------
     -7,-4,0,0,3,3,5,5,6,6

     build sorted index map:
     9 8 6 7 4 5 0 1 2 3
     --------------------
     0 1 2 3 4 5 6 7 8 9

     ======================================
     */

    public long maxBalancedSubsequenceSum(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        for (int n : nums) {
            maxVal = Math.max(maxVal, n);
        }
        // if max val < 0 then only single element is a healthy subsequence
        if (maxVal < 0) {
            return (long)maxVal;
        }

        int n = nums.length;
        long[] ans = new long[n];

        // use Segment Tree - Range Query's O(LogN) Time
        SegmentTree st = new SegmentTree(ans);

        // build val to idx array
        int[][] val2Idx = new int[n][2];
        for (int i = 0; i < n; i++){
            val2Idx[i][0] = nums[i] - i;
            val2Idx[i][1] = i;
        }
        // sort by value
        Arrays.sort(val2Idx, (a, b) -> {
            int diff = a[0] - b[0];
            if (diff == 0) {
                diff = a[1] - b[1];
            }
            return diff;
        });

        Map<Integer, Integer> sorted_idx_map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sorted_idx_map.put(val2Idx[i][1], i);
        }

        for (int i = n-1; i >= 0; i--) {
            int idx = sorted_idx_map.get(i);
            long curVal = nums[i] + st.query(idx, n-1, 0, n-1, 0);
            st.update(idx, curVal, 0, n-1, 0);
        }

        return st.tree[0];
    }

    // maintain max value
    class SegmentTree {
        public long[] tree;
        public long[] lazyTree;

        SegmentTree(long[] nums) {
            int n = nums.length;
            int height = (int)Math.ceil(Math.log(n) / Math.log(2));
            int size = 2 * (int)Math.pow(2, height) - 1;

            tree = new long[size];
            lazyTree = new long[size];

            build(0, n-1, 0, nums);
        }

        void build(int left, int right, int index, long[] nums) {
            if (left == right) {
                tree[index] = nums[left];
                return;
            }

            int mid = (left + right) >> 1;
            build(left, mid, 2 * index + 1, nums);
            build(mid+1, right, 2 * index + 2, nums);

            tree[index] = Math.max(tree[2 * index + 1], tree[2 * index + 2]);
        }

        void updateLazy(int left, int right, int index) {
            if (lazyTree[index] == 0) {
                return;
            }

            if (left != right) {
                lazyTree[2*index+1] = lazyTree[index];
                lazyTree[2*index+2] = lazyTree[index];
            }

            //int gap = right - left + 1;
            // for max value, just add the delta
            tree[index] += lazyTree[index];

            lazyTree[index] = 0;
        }

        // range query
        long query(int x, int y, int left, int right, int index) {
            // no overlap
            if (x > right || y < left) {
                // return 0;
                return Long.MIN_VALUE;
            }

            // handle lazy update first
            updateLazy(left, right, index);

            // complete overlap
            if (x <= left && right <= y) {
                return tree[index];
            }

            // semi overlap
            int mid = (left + right) >> 1;
            long leftTree = query(x, y, left, mid, 2 * index + 1);
            long rightTree = query(x, y, mid+1, right, 2 * index + 2);

            return Math.max(leftTree, rightTree);
        }

        // point update
        void update(int targetIdx, long val, int left, int right, int index) {
            if (left == right) {
                tree[index] = val;
                return;
            }

            int mid = (left + right) >> 1;
            if (mid >= targetIdx) {
                update(targetIdx, val, left, mid, 2 * index + 1);
            } else {
                update(targetIdx, val, mid+1, right, 2 * index + 2);
            }

            tree[index] = Math.max(tree[2 * index + 1], tree[2 * index + 2]);
        }
    }

    public static void main(String[] args) {
        MaxBalancedSubsequenceSum_LE_2926 solution = new MaxBalancedSubsequenceSum_LE_2926();
//        int[] nums = {5,6,8,9,7,8,6,7,4,2};

        int[] nums = {3,3,5,6}; //14

        System.out.println(solution.maxBalancedSubsequenceSum(nums));
    }
}
