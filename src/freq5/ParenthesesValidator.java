package freq5;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author jianshen
 */
public class ParenthesesValidator {
    //level 2
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;

        Stack stack = new Stack();
        char[] charArr = s.toCharArray();

        for (char c : charArr){
            if (isCloseParentheses(c)) {
                if (stack.size() == 0 || !isParenthesesMatch((Character)stack.pop(), c)){
                    return false;
                }
                continue;
            }else {
                stack.push(c);
            }
        }

        if (stack.size() == 0) return true;

        return false;
    }

    private static boolean isCloseParentheses(char c){
        List<Character> closeParentheses = Arrays.asList(')', ']', '}');
        return closeParentheses.contains(c);
    }

    private static boolean isParenthesesMatch(char open, char close){
        switch (open){
            case '(':
                if (close == ')') return true;
                return false;
            case '[':
                if (close == ']') return true;
                return false;
            case '{':
                if (close == '}') return true;
                return false;
            default:
                return false;
        }
    }

    public static void main(String[] args){
        String test = "()";
//        String test = "(){}[]";
//        String test = "(]";
//        String test = "([)]";
//        String test = "()9";
//        String test =  "(";
//        String test =  "";
//        String test = "([])";

        boolean result = isValid(test);
        System.out.println("for input string: " + test + ", validation result is: " + result);
    }
}
