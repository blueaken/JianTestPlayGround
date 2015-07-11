package leetcode.easy.validparenthese;

/**
 * Created by jshe18 on 7/10/15.
 */
public class SolutionTest {

    public static void main(String[] args){
//        Solution solution = new Solution();

//        String test1= "({[]})";
//        System.out.println("expected result for test1 is true: the actual result is: " + solution.isValid(test1));
//
//        String test2= "({[]}))";
//        System.out.println("expected result for test1 is false: the actual result is: " + solution.isValid(test2));
//
//        String test3= "(";
//        System.out.println("expected result for test1 is false: the actual result is: " + solution.isValid(test3));

        Solution_Refactored solutionRefactored = new Solution_Refactored();
        String test1= "({[]})";
        System.out.println("expected result for test1 is true: the actual result is: " + solutionRefactored.isValid(test1));

        String test2= "({[]}))";
        System.out.println("expected result for test1 is false: the actual result is: " + solutionRefactored.isValid(test2));

        String test3= "(";
        System.out.println("expected result for test1 is false: the actual result is: " + solutionRefactored.isValid(test3));

    }
}
