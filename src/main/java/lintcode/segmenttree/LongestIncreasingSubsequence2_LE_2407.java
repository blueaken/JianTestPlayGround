package lintcode.segmenttree;

public class LongestIncreasingSubsequence2_LE_2407 {
    /**
     11.09.23
     ref - https://leetcode.com/problems/longest-increasing-subsequence-ii/solutions/2560747/java-easy-segment-tree/ && CodingMohan video - https://www.youtube.com/watch?v=uGL3m7mq1L8
     - solve it with Segment Tree, Time is O(NLogK)
     */
    public int lengthOfLIS(int[] nums, int k) {
        int[] arr = new int[100001];
        SegmentTree st = new SegmentTree(arr);

        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int l = Math.max(0, nums[i] - k);
            int r = nums[i] - 1;
            int curVal = 1 + st.query(l, r, 0, arr.length-1, 0);
            st.update(nums[i], curVal, 0, arr.length-1, 0);
        }
        return st.tree[0];
    }

    class SegmentTree{
        int[] tree;

        SegmentTree(int[] nums) {
            int size = 4 * nums.length;
            tree = new int[size];
        }

        int query(int x, int y, int left, int right, int index) {
            if (x > right || y < left) {
                return Integer.MIN_VALUE;
            }

            if (x <= left && right <= y) {
                return tree[index];
            }

            int mid = (left + right) >> 1;
            int leftTree = query(x, y, left, mid, 2*index+1);
            int rightTree = query(x, y, mid+1, right, 2*index+2);

            return Math.max(leftTree, rightTree);
        }

        void update(int idx, int val, int left, int right, int index) {
            if (left == right) {
                tree[index] = val;
                return;
            }

            int mid = (left + right) >> 1;
            if (mid >= idx) {
                update (idx, val, left, mid, 2*index+1);
            } else {
                update (idx, val, mid+1, right, 2*index+2);
            }

            tree[index] = Math.max(tree[2*index+1], tree[2*index+2]);
        }
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence2_LE_2407 solution = new LongestIncreasingSubsequence2_LE_2407();
        int[] nums = {7,4,5,1,8,12,4,7};
        int k = 5;
        // 4

        System.out.println(solution.lengthOfLIS(nums, k));
    }
}
