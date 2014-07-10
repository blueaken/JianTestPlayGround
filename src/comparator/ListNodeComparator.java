package comparator;

import type.ListNode;

import java.util.Comparator;

/**
 * Author: blueaken
 * Date: 7/9/14 9:21 下午
 */
public class ListNodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode a, ListNode b){
        return a.val - b.val;
    }
}
