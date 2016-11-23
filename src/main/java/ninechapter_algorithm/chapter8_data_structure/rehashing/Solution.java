package ninechapter_algorithm.chapter8_data_structure.rehashing;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 5/1/16 09:29
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public static ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null || hashTable.length == 0) {
            return hashTable;
        }

        int capacity = hashTable.length * 2;
        ListNode[] result = new ListNode[capacity];
        for (int i = 0; i < hashTable.length; i++) {
            ListNode node = hashTable[i];
            while (node != null) {
                int hashKey = hashcode(node.val, capacity);
                if (result[hashKey] == null) {
                    result[hashKey] = new ListNode(node.val);
                } else {
                    ListNode newNode = result[hashKey];
                    while (newNode.next != null) {
                        newNode = newNode.next;
                    }
                    newNode.next = node;
                }
                node = node.next;
            }
        }
        return result;
    }

    private static int hashcode(int key, int capacity) {
        if (key >= 0 ) {
            return key % capacity;
        } else {
            //note - make sure the hashcode is not negative
            return (key % capacity + capacity) % capacity;
        }

    }

    public static void main(String[] args) {
        //happy path tc
//        ListNode[] hashTable = new ListNode[4];
//        ListNode one = new ListNode(21);
//        one.next = new ListNode(9);
//        ListNode two = new ListNode(14);
//        hashTable[1] = one;
//        hashTable[2] = two;

        //collision tc
//        ListNode[] hashTable = new ListNode[3];
//        ListNode two = new ListNode(29);
//        two.next = new ListNode(5);
//        hashTable[2] = two;

        //negative key tc
        ListNode[] hashTable = new ListNode[3];
        ListNode two = new ListNode(-29);
        two.next = new ListNode(-5);
        hashTable[2] = two;

        ListNode[] newHashTable = rehashing(hashTable);
        int count = 0;
        for (ListNode node : newHashTable) {
            System.out.println("node: " + count++);
            if (node != null) {
                node.print();
            }
            System.out.println();
        }
    }
}
