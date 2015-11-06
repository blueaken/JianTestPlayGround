package leetcode.easy.minstack.second;

/**
 * Created by jshe18 on 11/5/15.
 */
public class SolutionTest {
    public static void main(String[] args){
        //Solution minStackSolution = new Solution();
        Solution_MinStackNode minStackSolution = new Solution_MinStackNode();

        minStackSolution.push(512);
        minStackSolution.push(-1024);
        minStackSolution.push(-1024);
        minStackSolution.push(512);

        minStackSolution.pop();
        System.out.println(minStackSolution.getMin());
        minStackSolution.pop();
        System.out.println(minStackSolution.getMin());
        minStackSolution.pop();
        System.out.println(minStackSolution.getMin());
    }
}
