package leetcode.hard.copyrandomlist;

import type.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jshe18 on 9/18/15.
 */
public class Solution_OneMap {
    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) return null;
        RandomListNode p = head;
        RandomListNode dummy = new RandomListNode(-999);
        RandomListNode q = dummy;
        Map<RandomListNode, RandomListNode> map = new HashMap();

        while (p!=null){
            q.next = new RandomListNode(p.label);
            map.put(p, q.next);
            p = p.next;
            q = q.next;
        }

        p = head;
        q = dummy;
        while (p!=null){
            q.next.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }

        return dummy.next;
    }

    public static void main(String[] args){
        //test case 1
        RandomListNode head = new RandomListNode(0);
        RandomListNode one = new RandomListNode(1);
        RandomListNode two = new RandomListNode(2);
        RandomListNode three = new RandomListNode(3);

        head.next = one;
        head.random = one;
        one.next = two;
        one.random = head;
        two.next = three;
        two.random = null;
        three.random = three;

        RandomListNode newHead = copyRandomList(head);
        while (newHead!=null){
            System.out.println("RP label is: " + newHead.label + ", RP random label is: " + (newHead.random == null ? "empty" : newHead.random.label));
            newHead = newHead.next;
        }
    }
}
