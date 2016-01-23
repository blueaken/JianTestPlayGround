package leetcode.hard.validnumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 1/22/16 3:43 PM
 */
public class Solution {
    public static boolean isNumber(String s) {
        int i = 0;
        int n = s.length();

        while(i<n && Character.isWhitespace(s.charAt(i))) i++;

        if (i<n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;

        boolean isNumeric = false;
        while (i<n && Character.isDigit(s.charAt(i))) {
            i++;
            isNumeric = true;
        }

        if (i<n && s.charAt(i) == '.') i++;
        while (i<n && Character.isDigit(s.charAt(i))) {
            i++;
            isNumeric = true;
        }

        while(i<n && Character.isWhitespace(s.charAt(i))) {
            i++;
        }

        return isNumeric && i==n;
    }

    public static void main(String[] args){
        List<String> testList = new ArrayList<>();
        testList.add(" +321");
        testList.add("    ");
        testList.add("+");
        testList.add(" +3");
        testList.add(" -321");
        testList.add(" -321rrr");
        testList.add("+ 321");
        testList.add("+ 321rrr");
        testList.add("+321  ");
        testList.add("2.34");
        testList.add(".");
        testList.add("3.");
        testList.add(".3");
        testList.add("0xff");

        for (String test : testList){
            boolean value = isNumber(test);
            System.out.println(test + " is a number: " + value);
        }
    }
}
