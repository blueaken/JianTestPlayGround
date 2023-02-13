package lintcode.stack;

import java.util.TreeSet;

public class MaxStack_LE_716 {
    /**
     2.13.2023
     - ref official solution link - with 2 tree sets
     */

    TreeSet<int[]> stack; // id, value
    TreeSet<int[]> value; // value, id
    int id;

    public MaxStack_LE_716() {
        stack = new TreeSet<>((a, b) -> b[0] - a[0]); // sort by id in descending order, simulating a stack
        value = new TreeSet<>((a, b) -> {
            // sort by value in descending order, if values are same, choose the one with bigger id
            int diff = b[0] - a[0];
            if (diff == 0) {
                diff = b[1] - a[1];
            }
            return diff;
        });
        id = 0;
    }

    public void push(int x) {
        stack.add(new int[] {id, x});
        value.add(new int[] {x, id});
        id++;
    }

    public int pop() {
        int[] cur = stack.pollFirst();
        value.remove(new int[] {cur[1], cur[0]});
        return cur[1];
    }

    public int top() {
        return stack.first()[1];
    }

    public int peekMax() {
        return value.first()[0];
    }

    public int popMax() {
        int[] cur = value.pollFirst();
        stack.remove(new int[] {cur[1], cur[0]});
        return cur[0];
    }
}
