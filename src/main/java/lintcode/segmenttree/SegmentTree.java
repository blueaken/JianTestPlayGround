package lintcode.segmenttree;

/**
 * 11.01.23
 * ref CodingMohan's YouTube segment tree series:
 * https://www.youtube.com/watch?v=U5cedpBSSHg&list=PL9TOCZErLZcN4eFIBvFNJ3SirAeMFzTfz&index=12
 * https://www.youtube.com/watch?v=tcsPJFKoNNY&list=PL9TOCZErLZcN4eFIBvFNJ3SirAeMFzTfz&index=12
 * His video is wordy but with clear logic
 *
 * Assumption:
 * - build the tree with array instead of Tree Node, if the root index is i, then left child index is i*2+1, right child index is i*2+2, so on and so forth
 * - the array index of root node is always 0
 * - for Leaf Node, the left and right index is always same
 */
public class SegmentTree {

    public int[] tree;
    public int[] lazyTree;
    SegmentTree(int[] arr) {
        int n = arr.length;

        //Height of the tree，Math.pow(2, height) is the leaf nodes number of a full binary tree
        int height = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        //Maximum size of the tree
        int maxSize = 2 * (int) Math.pow(2, height) - 1;

        tree = new int[maxSize];
        lazyTree = new int[maxSize];
        build(0, n-1, 0, arr);
    }

    /**
     * Build Segment Tree on an array, each tree node keeps the range sum within its left & right index
     * @param left
     * @param right
     * @param index
     * @param arr
     */
    void build(int left, int right, int index, int[] arr) {
        // base case - hit a leaf node
        if (left == right) {
            tree[index] = arr[left];
            return;
        }
        int mid = left + ((right - left) >> 1);
        build(left, mid, index*2+1, arr);
        build(mid+1, right, index*2+2, arr);

        // post traverse handling, similar to merge sort
        tree[index] = tree[index*2+1] + tree[index*2+2];
    }

    /**
     * Range Query Function - need update after lazy propagation for range update is implemented
     * @param x
     * @param y
     * @param left
     * @param right
     * @param index
     * @return
     */
    int query(int x, int y, int left, int right, int index) {
        // base case - if the query range has no overlap with current node, return invalid value, for this Sum Function, return 0
        if (x > right || y < left) {
            return 0;
        }

        // handle lazy update before traverse
        if (lazyTree[index] != 0) {
            tree[index] += (right - left + 1) * lazyTree[index];
            if (left != right) {
                lazyTree[index*2+1] += lazyTree[index];
                lazyTree[index*2+2] += lazyTree[index];
            }
            lazyTree[index] = 0;
        }

        // base case - if the query range is completely overlap with current node, return the current node value
        if (x <= left && right <= y) {
            return tree[index];
        }

        // if half overlap then query the left & right child
        int mid = left + ((right - left) >> 1);
        int leftRange = query(x, y, left, mid, index*2+1);
        int rightRange = query(x, y,mid+1, right, index*2+2);

        // post traverse handling
        return leftRange + rightRange;
    }

    /**
     * Range Update Function (Lazy Propagation) - ref post: https://www.enjoyalgorithms.com/blog/segment-trees-data-structure-part-2
     * Time - O(LogN)
     * @param x
     * @param y
     * @param updateVal
     * @param left
     * @param right
     * @param index
     */
    void rangeUpdate(int x, int y, int updateVal, int left, int right, int index) {
        // handle lazy update first
        if (lazyTree[index] != 0) {
            tree[index] += (right - left + 1) * lazyTree[index];
            if (left != right) {
                lazyTree[index*2+1] += lazyTree[index];
                lazyTree[index*2+2] += lazyTree[index];
            }
            lazyTree[index] = 0;
        }

        // base case - if the input range has no overlap with current node, do nothing
        if (x > right || y < left) {
            return;
        }
        // base case - if the input range is completely overlap with current node, update the current node val and apply lazy propagation on its child
        if (x <= left && right <= y) {
            tree[index] += (right - left + 1) * updateVal;
            if (left != right) {
                // apply lazy propagation
                lazyTree[index*2+1] += updateVal;
                lazyTree[index*2+2] += updateVal;
            }
            return;
        }

        // if half overlap then query the left & right child
        int mid = left + ((right - left) >> 1);
        rangeUpdate(x, y, updateVal, left, mid, index*2+1);
        rangeUpdate(x, y,updateVal, mid+1, right, index*2+2);

        // in case child nodes val updated
        tree[index] = tree[index*2+1] + tree[index*2+2];
    }

    //    /**
//     * Point Update Function - With the introduction of Range Update Function, this Point Update Function should not be used, otherwise there will be a bug, since lazyTree nodes is not maintained in Point Update Function.
//     * @param targetIndex
//     * @param value
//     * @param left
//     * @param right
//     * @param index
//     */
//    void update(int targetIndex, int value, int left, int right, int index) {
//        if (left == right) {
//            // find targetIndex, update the value
//            tree[index] = value;
//            return;
//        }
//
//        int mid = left + ((right - left) >> 1);
//        if (mid >= targetIndex) {
//            // update on left child
//            update(targetIndex, value, left, mid, index*2+1);
//        } else {
//            // update on right child
//            update(targetIndex, value, mid+1, right, index*2+2);
//        }
//
//        // post traverse handling - update the tree node value along the path back
//        tree[index] = tree[index*2+1] + tree[index*2+2];
//    }

    public static void main(String[] args) {

        int[] nums = {1,3,5,7,9,11};
        SegmentTree solution = new SegmentTree(nums);

        System.out.println("Sum of values in given range = " +
                solution.query(1, 3, 0, nums.length-1, 0));

        // Range Update: set arr[1..3] value to increase 1
        solution.rangeUpdate(1, 3, 1, 0, nums.length-1, 0);

        // Find sum after the value is range updated
        System.out.println("Range Updated sum of values in given range = " +
                solution.query(1, 3, 0, nums.length-1, 0));

        //        // Update: set arr[1] = 10 and update corresponding segment tree nodes
//        solution.update(1, 10, 0, nums.length-1, 0);
//
//        // Find sum after the value is updated
//        System.out.println("Updated sum of values in given range = " +
//                solution.query(1, 3, 0, nums.length-1, 0));

    }
}
