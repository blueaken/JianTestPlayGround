package ninechapter_algorithm.chapter8_data_structure.optional.implementstackby2queues.second;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 5/30/16 08:33
 */
public class Stack {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
        if (q1.size() == 0 && q2.size() == 0) {
            q1.offer(x);
        } else if (q1.size() != 0){
            q1.offer(x);
        } else {
            q2.offer(x);
        }
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        if (q1.size() != 0) {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            q1.poll();
        } else {
            while (q2.size() > 1) {
                q1.offer(q2.poll());
            }
            q2.poll();
        }
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        if (q1.size() != 0) {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            int val = q1.poll();
            q2.offer(val);
            return val;
        } else {
            while (q2.size() > 1) {
                q1.offer(q2.poll());
            }
            int val = q2.poll();
            q1.offer(val);
            return val;
        }
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return q1.size() == 0 && q2.size() == 0;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.pop();
        System.out.println(stack.top());
    }
}
