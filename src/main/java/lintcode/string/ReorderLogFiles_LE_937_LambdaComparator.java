package lintcode.string;

import java.util.Arrays;

/* Ref - https://leetcode.com/problems/reorder-data-in-log-files/solution/, have to
         know the Comparator knowledge, not easy level
*/
public class ReorderLogFiles_LE_937_LambdaComparator {
    /*
       - refactor previous solution with lambda comparator expression
   */
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            //note the split(regex, limit) usage, which limits the number of return array elements
            String[] arr1 = a.split(" ", 2);
            String[] arr2 = b.split(" ", 2);
            boolean isDigitLog1 = Character.isDigit(arr1[1].charAt(0));
            boolean isDigitLog2 = Character.isDigit(arr2[1].charAt(0));

            if (!isDigitLog1 && !isDigitLog2) {
                int temp = arr1[1].compareTo(arr2[1]);
                if (temp != 0) {
                    return temp;
                } else {
                    return arr1[0].compareTo(arr2[0]);
                }
            } else if (isDigitLog1 && isDigitLog2) {
                return 0;
            } else if (isDigitLog1) {
                return 1;
            } else {
                return -1;
            }
        });
        return logs;
    }
}
