package realworld.interviewprep.morganstanley;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianshen
 */
public class FirstNonRepeatCharFinder {
    /*
    * There are 2 ways to understand the question, ask for clarification if met.
    * The 1st case is the 1st non repeated char occurs, where input "GeeksforGeeks" should return 'G'.
    * The 2nd case is the 1st non repeated char of the scope, where "GeeksforGeeks" should return 'f'.
    * The 2nd case is has an elegant solution with HashMap, while we still can solve the 1st case in one
    * iteration. For fun, I put both solutions below.
     */
    public static void main(String[] args){
        String input = "GeeksforGeeks";

        System.out.println("First Occurred Non Repeat Character is: " + findFirstNonRepeatChar_Occur(input));
        System.out.println("First Non Repeat Character of the string is: " + findFirstNonRepeatChar_Scope(input));
    }

    /*
    * the 2nd case.
     */
    private static char findFirstNonRepeatChar_Scope(String input){
        char not_found = '!';
        Map<Character, Boolean> count = new HashMap<Character, Boolean>();
        for (int i=0; i<input.length(); i++){
            if (count.get(input.charAt(i)) == null){
                count.put(input.charAt(i), true);
            }else {
                count.put(input.charAt(i), false);
            }
        }

        for (int i=0; i<input.length(); i++){
            if (count.get(input.charAt(i))){
                return input.charAt(i);
            }
        }

        return not_found;

    }

    /*
    * the 1st case.
     */
    private static char findFirstNonRepeatChar_Occur(String input){
        char not_found = '!';

        int size = input.length();
        if (size==0) return not_found;
        if (size==1) return input.charAt(0);

        //if size >=2
        int ind = 0;
        while((ind+1) < size){
            if (input.charAt(ind) != input.charAt(ind+1)){
                if (ind == 0){
                    return input.charAt(ind);   //the case 1st non repeated char at the head of the string
                }else {
                    if ((ind+2)<size){
                        if (input.charAt(ind+1)!=input.charAt(ind+2)){
                            return input.charAt(ind+1);
                        }
                    } else {//the case 1st non repeated char at the end of the string
                        return input.charAt(ind+1);
                    }

                }

            }
            ind++;
        }

        return not_found;
    }
}
