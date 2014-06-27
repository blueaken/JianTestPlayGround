package sort;

import type.TreeNode;

/**
 * @author jianshen
 */
public class sortedArrayToBST {

    //yeah, 我的解法和flightforyourdream大侠几乎一样
    public static TreeNode sortedArrayToBST(int[] num) {
        TreeNode bst = buildBST(num, 0, num.length-1);
        return bst;
    }

    private static TreeNode buildBST(int[] num, int start, int end){
        if (start > end) return null;

        int mid = start + (end - start)/2;

        TreeNode root = new TreeNode(num[mid]);
        root.left = buildBST(num, start, mid-1);
        root.right = buildBST(num, mid+1, end);

        return root;
    }


//    public static TreeNode sortedArrayToBST(int[] num) {
//        TreeNode bst = sortedArrayToBSTRec(num, 0, num.length-1);
//        return bst;
//    }
//
//    // 二分查找节点值，并递归创建节点
//    private static TreeNode sortedArrayToBSTRec(int[] num, int low, int high){
//        if(low > high){
//            return null;
//        }
//        int mid = low + (high-low)/2;       // 找到中值
//        TreeNode root = new TreeNode(num[mid]);     // 创建根节点
//        root.left = sortedArrayToBSTRec(num, low, mid - 1);       // 递归创建左子树和右子树
//        root.right = sortedArrayToBSTRec(num, mid + 1, high);
//        return root;
//    }

    public static void main(String[] args){
        int[] sortedArr = {1,2,3,4,5,6,7,8,9};
        TreeNode bst = sortedArrayToBST(sortedArr);

    }
}
