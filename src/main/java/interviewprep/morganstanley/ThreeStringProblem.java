package interviewprep.morganstanley;

import java.util.BitSet;

/**
 * @author jianshen
 */
/*
*Given three strings str1, str2 and str3; complete the function to find the smallest subsequence in str1 which contains
 *  all the characters in str2 (in any order) and not those in str3.
Sample Test Case:
Sample Input:
str1: spqrstrupvqw
str2: sprt
str3: q
Sample Output: strup

Explanation: In the given string str1, the smallest subsequence that contains the characters in str2 ( 's' , 'p' , 'r'
, 't' ) and does not contain the character in str3 ( 'q' ) is 'strup'.
 */

/*
1. Split the str1 with each character of the str3.
2. Now iterate all the words and check the constraint that word contain all the characters of str2, Checking can be skipped by comparing string lengths.
3. Return the minimum length string which satisfies point 2.
 */
/*
    Think about it twice and notice it is possible there are more than one characters on string 3, which fails the
    split step above. Need a better way to handle this.
*/
public class ThreeStringProblem {
    public static void main(String[] args){
        String one = "spqrstrupvqw";
        String two = "sprt";
        String three = "q";

        System.out.println("The min length string meets expectation is: " + findMinLengthString(one, two, three));
    }

    private static String findMinLengthString (String original, String include, String avoid){
        if (original == null) {
            return "empty original string error";
        }

        String minLengthString = "";
        int minLength = Integer.MAX_VALUE;

        // Sliding window; Start from index 0 with a window of size equivalent
        // to String two and increment by one character every iteration
        for (int i=0; i<original.length(); i++)
           for(int j=i+include.length(); j<original.length(); j++){
                //get the subString
               String toCheck = original.substring(i, j);
               if (IsGoodString(toCheck, include, avoid)){
                   if (toCheck.length() < minLength){
                       minLengthString = toCheck;
                       minLength = toCheck.length();
                   }
               }
           }

        return minLengthString;
    }

    /**
     * The method is used to check if all the characters of String include are
     * present in String toCheck but not that of String avoid
     */
    /*
    * 这里考虑用BitSet而不用HashSet,
    * 参考：http://www.importnew.com/977.html
     */
    private static boolean IsGoodString(String toCheck, String include, String avoid){
        BitSet bitSet = new BitSet();

        for (int i=0; i<toCheck.length(); i++){
            bitSet.set(toCheck.charAt(i));
        }

        for (int i=0; i<include.length(); i++){
            if (!bitSet.get(include.charAt(i))){
                return false;
            }
        }

        for (int i=0; i<avoid.length(); i++){
            if (bitSet.get(avoid.charAt(i))){
                return false;
            }
        }

        return true;
    }
}
