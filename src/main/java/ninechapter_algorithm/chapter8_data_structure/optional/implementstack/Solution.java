package ninechapter_algorithm.chapter8_data_structure.optional.implementstack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 6/6/16 08:51
 */
public class Solution {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
        if (q2.isEmpty()) {
            q1.offer(x);
        } else {
            q2.offer(x);
        }
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            q1.poll();
        } else if (!q2.isEmpty()) {
            while (q2.size() > 1) {
                q1.offer(q2.poll());
            }
            q2.poll();
        }
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        int ret = -1;
        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            ret = q1.peek();
            q2.offer(q1.poll());
        } else if (!q2.isEmpty()) {
            while (q2.size() > 1) {
                q1.offer(q2.poll());
            }
            ret = q2.peek();
            q1.offer(q2.poll());
        }
        return ret;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return q1.isEmpty() && q2.isEmpty();
    }
}
