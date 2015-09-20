package leetcode.hard.copyrandomlist;

import type.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jshe18 on 9/16/15.
 */
//deep copy the list w/o random pointer
public class Solution {
    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) return null;

        RandomListNode dummy = new RandomListNode(-999);
        dummy.next = head;

        RandomListNode dummyNew = new RandomListNode(-999);
        RandomListNode p = dummyNew;
        Map<Integer, Integer> randomLabelMap = new HashMap<>();
        Map<Integer, RandomListNode> randomPointerlMap = new HashMap<>();

        while (dummy.next!=null){
            RandomListNode cur = dummy.next;
            if (cur.random != null){
                randomLabelMap.put(cur.label, cur.random.label);
            }

            p.next = new RandomListNode(cur.label);
            p = p.next;
            randomPointerlMap.put(p.label, p);
            dummy = dummy.next;
        }

        p = dummyNew.next;
        while (p!=null) {
            Integer randomLabel = randomLabelMap.get(p.label);
            if (randomLabel!=null){
                p.random = randomPointerlMap.get(randomLabel);
            }
            p = p.next;
        }
        return dummyNew.next;
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
