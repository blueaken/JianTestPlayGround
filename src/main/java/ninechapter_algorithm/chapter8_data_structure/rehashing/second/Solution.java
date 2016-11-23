package ninechapter_algorithm.chapter8_data_structure.rehashing.second;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 6/1/16 11:15
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null || hashTable.length == 0) {
            return null;
        }

        int capacity = hashTable.length;
        int newCap = capacity * 2;
        ListNode[] result = new ListNode[newCap];
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                ListNode node = hashTable[i];
                while (node != null) {
                    ListNode next = node.next;
                    node.next = null;
                    //in case node.val is negative
                    int newPos = (node.val % newCap + newCap) % newCap;
                    addNode(result, newPos, node);
                    if (next != null) {
                        node = next;
                    } else {
                        break;
                    }
                }

            }
        }
        return result;
    }

    private void addNode(ListNode[] table, int pos, ListNode node) {
        if (table[pos] == null) {
            table[pos] = node;
        } else {
            ListNode cur = table[pos];
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }
}
