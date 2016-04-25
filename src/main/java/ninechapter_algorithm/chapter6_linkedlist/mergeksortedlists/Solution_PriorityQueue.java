package ninechapter_algorithm.chapter6_linkedlist.mergeksortedlists;

import type.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ListNodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode a, ListNode b) {
        if (a == null) {
            return 1;
        }
        if (b == null) {
            return -1;
        }
        return a.val - b.val;
    }
}

/**
 * Author: blueaken
 * Date: 4/25/16 12:05 PM
 */
public class Solution_PriorityQueue {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public static ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(), new ListNodeComparator());
        for (ListNode list : lists) {
            pq.add(list);
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (pq.size() > 0) {
            ListNode cur = pq.poll();
            tail.next = cur;
            tail = tail.next;
            if (cur.next != null) {
                pq.add(cur.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args){
        //1,4,7
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(4);
        ln1.next.next = new ListNode(7);

        //2,5,8
//        ListNode ln2 = new ListNode(2);
//        ln2.next = new ListNode(5);
//        ln2.next.next = new ListNode(8);
        ListNode ln2 = null;

        //3,6,9
//        ListNode ln3 = new ListNode(3);
//        ln3.next = new ListNode(6);
//        ln3.next.next = new ListNode(9);
        ListNode ln3 = null;

        List<ListNode> lists = new ArrayList<>(3);
        lists.add(ln1);
        lists.add(ln2);
        lists.add(ln3);

        //1,2,3,4,5,6,7,8,9
        mergeKLists(lists).print();
    }
}
