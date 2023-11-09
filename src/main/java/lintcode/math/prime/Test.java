package lintcode.math.prime;

import java.util.*;

public class Test {

    int N = 1_00_001;

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

//    int seg[];
//    void update(int idx , int x , int low , int high , int i){
//        if(low == high){
//            seg[idx] = x;
//            return;
//        }
//        int mid = low + (high - low) / 2;
//        if(i <= mid){
//            update(2 * idx + 1 , x , low , mid , i);
//        }
//        else{
//            update(2 * idx + 2 , x , mid + 1 , high , i);
//        }
//        seg[idx] = Math.max(seg[2 * idx + 1], seg[2 * idx + 2]);
//    }
//    int query(int l , int r , int low , int high , int idx){ // max query
//        if(l > high || r < low){
//            return Integer.MIN_VALUE;
//        }
//        if(low >= l && high <= r){
//            return seg[idx];
//        }
//        int mid = low + (high - low) / 2;
//        int left = query(l , r , low , mid , 2 * idx + 1);
//        int right = query(l , r , mid + 1 , high , 2 * idx + 2);
//        return Math.max(left , right);
//    }

    public int lengthOfLIS(int[] a, int k) {
        int n = a.length;
        int max = 0;
        int[]seg = new int[4 * N];
        SegmentTree st = new SegmentTree(seg);
        for(int i = 0; i < n; i++){
            int l = Math.max(0 , a[i] - k);
            int r = a[i] - 1;
            int res = st.query(l , r , 0 , N - 1 , 0) + 1; // search in all the possible previous elements ([l , r]) and add '1' to the max                                                                length with this previous
            max = Math.max(max , res); // update max
            st.update(0 , res , 0 , N - 1 , a[i]); // update segment tree's a[i]th index with res
        }
        return max;
    }


    public static void main(String[] args) {
        Test test = new Test();

        int[] nums = {7,4,5,1,8,12,4,7};
        int k = 5;
        // 4

        System.out.println(test.lengthOfLIS(nums, k));
    }
}
