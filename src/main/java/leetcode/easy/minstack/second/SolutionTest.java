package leetcode.easy.minstack.second;

import leetcode.easy.minstack.MinStack_WithOneStack;

/**
 * Created by jshe18 on 11/5/15.
 */
public class SolutionTest {
    public static void main(String[] args){
//        Solution minStackSolution = new Solution();
        //Solution_MinStackNode minStackSolution = new Solution_MinStackNode();
        Solution_OneStack minStackSolution = new Solution_OneStack();
//        MinStack_WithOneStack minStackSolution = new MinStack_WithOneStack();

        //#test 1
//        minStackSolution.push(512);
//        minStackSolution.push(-1024);
//        minStackSolution.push(-1024);
//        minStackSolution.push(512);
//
//        minStackSolution.pop();
//        System.out.println(minStackSolution.getMin());
//        minStackSolution.pop();
//        System.out.println(minStackSolution.getMin());
//        minStackSolution.pop();
//        System.out.println(minStackSolution.getMin());

        //#test 2
//        minStackSolution.push(1);
//        minStackSolution.push(2);
//        System.out.println(minStackSolution.top());
//        System.out.println(minStackSolution.getMin());
//        minStackSolution.pop();
//        System.out.println(minStackSolution.getMin());
//        System.out.println(minStackSolution.top());

        //test #3
        minStackSolution.push(5);
        System.out.println(minStackSolution.getMin());

        minStackSolution.push(7);
        System.out.println(minStackSolution.getMin());

        minStackSolution.push(3);
        System.out.println(minStackSolution.getMin());

        System.out.println(minStackSolution.pop());
        System.out.println(minStackSolution.pop());
        System.out.println(minStackSolution.pop());

    }
}
