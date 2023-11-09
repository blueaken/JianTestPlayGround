package lintcode.segmenttree;

import java.util.*;
public class LongestIncreasingSubsequence_LE300 {
    /*
        10.17.2022
        read labuladong post and redo
        - bottom up DP
        ===================
        10.17.2022
        - improve with Binary Search after reading solution link, improve from O(N^2) to O(NLogN)
        - Tag: Greedy, Binary Search
        ==================
        5.23.23
        - bottom up DP
        - try bs method of card game from 东哥 post
        ==================
        9.26.23
        - try BS method
        ==================
        11.09.23
        - ref CodingMohan's video, solve with Segment Tree
        - Time is O(NLogN)
        - note it need to iterate from left to right, instead of right to left, like LE 2926; for the problem statement
        ====================
        Dry Run Example -
        ori:
        0  1 2 3 4 5  6  7
        --------------------
        10,9,2,5,3,7,25,18

        sort by converted value:
        2 4 3 5 1  0  7 6
        ---------------------
        2,3,5,7,9,10,18,25

        build sorted index map:
        2 4 3 5 1  0  7 6
        ---------------------
        0,1,2,3,4, 5, 6,7

        ori:
        0  1 2 3 4 5  6 7
        --------------------
        10,9,2,5,3,7,25,18

        result list:
        2 4 3 5 1  0  7 6
        ---------------------
        0,1,2,3,4, 5, 6,7
        ---------------------
        1 2 2 3 1 1  4  4
        ==================
        ans: 4
    */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] val2Idx = new int[n][2];
        for (int i = 0; i < n; i++) {
            val2Idx[i][0] = nums[i];
            val2Idx[i][1] = i;
        }

        Arrays.sort(val2Idx, (a, b) -> {
            int diff = a[0] - b[0];
            if (diff == 0) {
                diff = b[1] - a[1]; // decreasing order since this LIS need be strictly increasing order
            }
            return diff;
        });

        Map<Integer, Integer> sortedIdxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sortedIdxMap.put(val2Idx[i][1], i);
        }

        int[] ans = new int[n];
        SegmentTree st = new SegmentTree(ans);
        for (int i = 0; i < n; i++) {
            int idx = sortedIdxMap.get(i);
            int curVal = 1 + st.query(0, idx, 0, n-1, 0);
            st.update(idx, curVal, 0, n-1, 0);
        }

        return st.tree[0];
    }

    class SegmentTree {
        int[] tree;

        SegmentTree(int[] nums) {
            int n = nums.length;
            int height = (int)Math.ceil(Math.log(n) / Math.log(2));
            int size = 2 * (int)Math.pow(2, height) - 1;

            tree = new int[size];
            build(0, n-1, 0, nums);
        }

        void build(int left, int right, int index, int[] nums) {
            if (left == right) {
                tree[left] = nums[left];
                return;
            }

            int mid = (left + right) >> 1;
            build(left, mid, 2 * index + 1, nums);
            build(mid+1, right, 2 * index + 2, nums);

            tree[index] = Math.max(tree[2*index+1], tree[2*index+2]);
        }

        int query(int x, int y, int left, int right, int index) {
            if (x > right || y < left) {
                return Integer.MIN_VALUE;
            }

            if (x <= left && right <= y) {
                return tree[index];
            }

            int mid = (left + right) >> 1;
            int leftTree = query(x, y, left, mid, 2 * index + 1);
            int rightTree = query(x, y, mid+1, right, 2 * index + 2);

            return Math.max(leftTree, rightTree);
        }

        void update (int targetIdx, int val, int left, int right, int index) {
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

            tree[index] = Math.max(tree[2*index+1], tree[2*index+2]);
        }
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence_LE300 solution = new LongestIncreasingSubsequence_LE300();
//        int[] nums = {10,9,2,5,3,7,101,18}; //4
        int[] nums = {7,7,7,7}; //1
        System.out.println(solution.lengthOfLIS(nums));
    }
}
