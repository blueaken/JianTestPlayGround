package lintcode.stack;

import java.util.Stack;

public class SubArrays_264 {
    /**
     * @param array: An given array.
     * @return: Return the number of "universal" subarrays.
     */
    //Note: 用stack来count, 一个是4,2顺序 一个是2，4顺序; 这两个顺序分别计算下有多少个加起来就行了；
    public int subarrays(int[] array) {
        // write your code here.
        if (array.length == 0) {
            return 0;
        }
        int count = 0;
        boolean isPreValid = false;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            int cur = array[i];
            if (cur == 4) {
                if (isPreValid) {
                    //连续分组结束
                    stack = new Stack<>();
                    isPreValid = false;
                }
                stack.push(cur);
            }
            if (cur == 2) {
                if (stack.size() > 0 && stack.peek() == 4) {
                    stack.pop();
                    count++;
                    isPreValid = true;
                }
            }
        }

        stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            int cur = array[i];
            if (cur == 2) {
                if (isPreValid) {
                    //连续分组结束
                    stack = new Stack<>();
                    isPreValid = false;
                }
                stack.push(cur);
            }
            if (cur == 4) {
                if (stack.size() > 0 && stack.peek() == 2) {
                    stack.pop();
                    count++;
                    isPreValid = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] input = {2,2,2,2,2,2,4,4,2,4,4,4,4,2,2,2,2,4,2,4};
//        int[] input = {2,2,2,4,4,2,4,4,2,2,4,2,4};
        SubArrays_264 solution = new SubArrays_264();
        System.out.println(solution.subarrays(input));
    }
}
