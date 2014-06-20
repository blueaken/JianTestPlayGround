/**
 * Created with IntelliJ IDEA.
 * User: blueaken
 * Date: 6/19/14
 * Time: 12:17 上午
 */

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 *  */
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

class ListNodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode a, ListNode b){
        return a.val - b.val;
    }
}

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeSortedKList {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) return null;
        Comparator<ListNode> listNodeComparator = new ListNodeComparator();
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.size(), listNodeComparator);
        for (ListNode listNode : lists){
            priorityQueue.add(listNode);
        }
        ListNode head = new ListNode(-999);
        ListNode p = head;

        while (lists.size() != 0) {
            ListNode current = priorityQueue.remove();
            p.val = current.val;
            p = p.next;
            if (current.next != null){
                priorityQueue.add(current);
            }
        }
        return head;
    }

}
