package realworld.amazon.prep.calculatestackoperationsequence;

import java.util.Stack;

/**
 * Author: blueaken
 * Date: 3/23/16 1:40 PM
 */
public class Solution {
    public static String calculateStackOperationSequence (int[] origin, int[] target) {
        if (origin == null || target == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        int len = origin.length;

        stack.push(origin[i]);
        result.append("Push " + origin[i]);
        result.append("|");
        i++;

        while(!stack.isEmpty()) {
            if (j < len && stack.peek() == target[j]) {
                stack.pop();
                result.append("Pop " + target[j]);
                result.append("|");
                j++;

                if (i < len) {
                    stack.push(origin[i]);
                    result.append("Push " + origin[i]);
                    result.append("|");
                    i++;
                }
            } else if (i < len) {
                stack.push(origin[i]);
                result.append("Push " + origin[i]);
                result.append("|");
                i++;
            } else {
                break;
            }
        }

        if (!stack.isEmpty()) {
            return "None";
        }

        return result.toString();

    }

    public static void main(String[] args) {
//        int[] origin = {1,2,3,4};
//        int[] target = {4,3,2,1};

        int[] origin = {1,2,3};
        int[] target = {1,3,2};

        System.out.println(calculateStackOperationSequence(origin, target));
    }
}
