package ninechapter_algorithm.chapter8_data_structure.optional.implementstackby2queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 4/30/16 14:56
 */
public class Stack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Push a new item into the stack
    public void push(int x) {
        // Write your code here
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.offer(x);
        } else if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            queue1.poll();
        } else if (!queue2.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            queue2.poll();
        }
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        int ret = 0;
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            ret = queue1.peek();
            queue2.offer(queue1.poll());
        } else if (!queue2.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            ret = queue2.peek();
            queue1.offer(queue2.poll());
        }
        return ret;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.pop();
        System.out.println(stack.top());
    }
}
