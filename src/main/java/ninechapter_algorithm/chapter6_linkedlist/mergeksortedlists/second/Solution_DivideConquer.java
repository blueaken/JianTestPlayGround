package ninechapter_algorithm.chapter6_linkedlist.mergeksortedlists.second;

import type.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 5/14/16 10:26
 */
public class Solution_DivideConquer {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }

        int end = lists.size() - 1;
        while (end > 0) {
            int start = 0;
            while (start < end) {
                lists.set(start, merge2ListNodes(lists.get(start++), lists.get(end--)));
            }
        }
        return lists.get(0);
    }

    private ListNode merge2ListNodes(ListNode start, ListNode end) {
        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        while (start != null && end != null) {
            if (start.val < end.val) {
                node.next = start;
                start = start.next;
            } else {
                node.next = end;
                end = end.next;
            }
            node = node.next;
        }
        if (start != null) {
            node.next = start;
        }
        if (end != null) {
            node.next = end;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution_DivideConquer solution_divideConquer = new Solution_DivideConquer();
        //1,4,7
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(4);
        ln1.next.next = new ListNode(7);

        //2,5,8
        ListNode ln2 = new ListNode(2);
        ln2.next = new ListNode(5);
        ln2.next.next = new ListNode(8);
//        ListNode ln2 = null;

        //3,6,9
        ListNode ln3 = new ListNode(3);
        ln3.next = new ListNode(6);
        ln3.next.next = new ListNode(9);
//        ListNode ln3 = null;

        List<ListNode> lists = new ArrayList<>(3);
        lists.add(ln1);
        lists.add(ln2);
        lists.add(ln3);

        //1,2,3,4,5,6,7,8,9
        solution_divideConquer.mergeKLists(lists).print();

    }
}
