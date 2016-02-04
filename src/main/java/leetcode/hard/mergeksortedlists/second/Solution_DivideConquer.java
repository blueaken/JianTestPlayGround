package leetcode.hard.mergeksortedlists.second;

import type.ListNode;

import java.util.List;

import leetcode.easy.mergetwosortedlists.second.Solution;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 2/3/16 12:09 PM
 */
public class Solution_DivideConquer {
    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null || lists.isEmpty()) return null;

        int end = lists.size()-1;
        while (end>0) {
            int start = 0;
            while (start < end) {
                lists.set(start, Solution.mergeTwoLists(lists.get(start), lists.get(end)));
                start++;
                end--;
            }
        }

        return lists.get(0);
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
