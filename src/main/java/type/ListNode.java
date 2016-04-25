package type;

/**
 * Definition for singly-linked list.
 *  */
 public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
          val = x;
          next = null;
    }

    public void print() {
        ListNode node = this;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.print("null");
        System.out.println();
    }

  }
