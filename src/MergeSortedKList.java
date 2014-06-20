/**
 * Created with IntelliJ IDEA.
 * User: blueaken
 * Date: 6/19/14
 * Time: 12:17 上午
 */

import java.util.*;

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
    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) return null;
        Comparator<ListNode> listNodeComparator = new ListNodeComparator();
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.size(), listNodeComparator);
        for (ListNode listNode : lists){
            priorityQueue.add(listNode);
        }
        ListNode head = new ListNode(-999);
        ListNode p = head;

        while (priorityQueue.size() != 0) {
            ListNode current = priorityQueue.remove();
            p.val = current.val;
            p.next = new ListNode(-999);
            p = p.next;
            if (current.next != null){
                priorityQueue.add(current.next);
            }
        }
        return head;
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
        }
    }

}
