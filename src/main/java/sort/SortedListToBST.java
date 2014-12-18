package sort;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: blueaken
 * Date: 6/27/14
 * Time: 10:16 下午
 */
public class SortedListToBST {
    /**
     * 本题和上题的难点在于list不能象array那样用O（1）来读取中位值。可用每次遍历两遍的方法，但时间复杂度太高。可以用快慢指针方法实现遍历一遍就找到中位值来解决。
     */
    //在区间[start, end)里递归，后面的end是包括在内的，这样可以避免要多用一个指针来记录mid前的节点
    public static TreeNode sortedListToBST(ListNode head) {
        TreeNode bst = buildBST(head, null);
        return bst;
    }

    private static TreeNode buildBST(ListNode start, ListNode end){
        if (start == end) return null;

        ListNode midNode = start;  //慢指针，最后会指向中点
        ListNode probeNode = start; //快指针，2倍探测速度
        while(probeNode!=end && probeNode.next!=end){
            midNode = midNode.next;
            probeNode = probeNode.next.next;
        }

        TreeNode root = new TreeNode(midNode.val);
        root.left = buildBST(start, midNode);
        root.right = buildBST(midNode.next, end);

        return root;
    }

    public TreeNode rec(ListNode start, ListNode end){
        if(start == end){
            return null;
        }

        ListNode mid = start;
        ListNode probe = start;
        while(probe!=end && probe.next!=end){
            mid = mid.next;
            probe = probe.next.next;
        }

        TreeNode root = new TreeNode(mid.val);
        root.left = rec(start, mid);
        root.right = rec(mid.next, end);
        return root;
    }

    /**
     * 自己的第一个解法是直接把list转化为array，时间和空间都为O（n）。可以通过OJ但真正面试时肯定不行。
     */
//    public static TreeNode SortedListToBST(ListNode head) {
//        if (head == null) return null;
//        List<Integer> al = new ArrayList<Integer>();
//        while (head != null){
//            al.add(head.val);
//            head = head.next;
//        }
//        Integer[] arr = al.toArray(new Integer[al.size()]);
//
//        TreeNode bst = buildBST(arr, 0, arr.length-1);
//        return bst;
//    }
//
//
//    private static TreeNode buildBST(Integer[] num, int start, int end){
//        if (start > end) return null;
//
//        int mid = start + (end - start)/2;
//
//        TreeNode root = new TreeNode(num[mid]);
//        root.left = buildBST(num, start, mid-1);
//        root.right = buildBST(num, mid+1, end);
//
//        return root;
//    }

    public static void main(String[] args){
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(3);
//        ln.next.next = new ListNode(3);
//        ln.next.next.next = new ListNode(4);
//        ln.next.next.next.next = new ListNode(5);
//        ln.next.next.next.next.next = new ListNode(6);
//        ln.next.next.next.next.next.next = new ListNode(7);

        TreeNode bst = sortedListToBST(ln);

    }
}
