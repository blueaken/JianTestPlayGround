package realworld.interviewprep.morganstanley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianshen on 12/21/14.
 */
/*
* There is a string , where a character is missing. Print the missing character. The range is present in the string and
 * the characters are case sensitive.  For example:-If input is "baADfc".  Here the range is a to f.  The missing
 * character to be printed is e.
 */
public class MissingCharFinder {
    public static void main(String[] args){
        String input = "baADfc";
        System.out.println("Input String: " + input);
        findMissingChar(input);
    }

    static void findMissingChar(String input){
        Map<Character, Boolean> count = new HashMap<Character, Boolean>();

        char[] charArray = input.toLowerCase().toCharArray();
        char min = charArray[0];
        char max = charArray[0];
        for (int i=0;i<charArray.length;i++){

            if (charArray[i] < min) {
                min = charArray[i];
            }

            if (charArray[i] > max) {
                max = charArray[i];
            }

            count.put(charArray[i], true);
        }

        System.out.println("The range of input is from " + min + " to " + max + ".");

        System.out.println("The missing char(s) is as following: ");
        for (char c = min; c <= max; c++ ){
            if (count.get(c) == null) {
                System.out.println(c);
            }
        }
    }
}
