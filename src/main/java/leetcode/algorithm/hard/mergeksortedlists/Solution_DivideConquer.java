package leetcode.algorithm.hard.mergeksortedlists;

import type.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jshe18 on 9/15/15.
 */
public class Solution_DivideConquer {

    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null || lists.isEmpty()) return null;
        int end = lists.size()-1;
        while (end>0) {
            int begin = 0;
            while (begin < end) {
                lists.set(begin, mergeTwoLists(lists.get(begin), lists.get(end)));
                end--;
                begin++;
            }
        }

        return lists.get(0);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(-1);
        ListNode current = temp;
        while (l1!=null && l2!=null){
            if (l1.val <= l2.val){
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1!=null){
            current.next = l1;
        }
        if (l2!=null){
            current.next = l2;
        }

        return temp.next;
    }

    public static void main(String[] args){
        //1,4,7
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(4);
        ln1.next.next = new ListNode(7);

        //2,5,8
        ListNode ln2 = new ListNode(2);
        ln2.next = new ListNode(5);
        ln2.next.next = new ListNode(8);

        //3,6,9
        ListNode ln3 = new ListNode(3);
        ln3.next = new ListNode(6);
        ln3.next.next = new ListNode(9);

        List<ListNode> lists = new ArrayList<ListNode>(3);
        lists.add(ln1);
        lists.add(ln2);
        lists.add(ln3);

        //1,2,3,4,5,6,7,8,9
        ListNode result = mergeKLists(lists);
        while (result!=null){
            System.out.print(result.val);
            result = result.next;
        }

        System.out.println();

        //null list
        List<ListNode> nullList = null;
        ListNode nullResult = mergeKLists(nullList);
        if (nullResult==null){
            System.out.println("result is null");
        }
    }
}
