package leetcode.hard.copyrandomlist.second;

import type.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 2/4/16 1:57 PM
 */
public class Solution {
    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) return null;
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode p = dummyHead;
        RandomListNode q = head;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (q!=null){
            RandomListNode node = new RandomListNode(q.label);
            map.put(q, node);
            p.next = node;

            p = p.next;
            q = q.next;
        }

        p = dummyHead;
        q = head;
        while(p.next!=null){
            p.next.random = map.get(q.random);
            p = p.next;
            q = q.next;
        }

        return dummyHead.next;
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
