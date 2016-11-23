package leetcode.algorithm.hard.mergeksortedlists;

import type.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by jshe18 on 9/14/15.
 */

public class Solution {

    private static final Comparator<ListNode> listComparator =
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode x, ListNode y) {
                    return x.val - y.val;
                }
            };

    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null || lists.isEmpty()) return null;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.size(), listComparator);

        for (ListNode listNode : lists){
            priorityQueue.add(listNode);
        }

        ListNode dummyHead = new ListNode(-999);
        ListNode point = dummyHead;
        while (priorityQueue.size()>0){
            ListNode cur = priorityQueue.poll();
            point.next = cur;
            point = point.next;

            if (cur.next!=null) priorityQueue.add(cur.next);
        }

        return dummyHead.next;
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
