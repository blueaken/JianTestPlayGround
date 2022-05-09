package lintcode.strings;

import java.util.Arrays;
import java.util.Comparator;

/* Ref - https://leetcode.com/problems/reorder-data-in-log-files/solution/, have to
         know the Comparator knowledge, not easy level
*/
public class ReorderLogFiles_LE_937 {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> com = new Comparator<String>(){
            @Override
            public int compare(String log1, String log2) {
                String[] r1 = log1.split(" ", 2);
                String[] r2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(r1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(r2[1].charAt(0));
                if (!isDigit1 && !isDigit2) {
                    int c = r1[1].compareTo(r2[1]);
                    if (c != 0) {
                        return c;
                    } else {
                        return r1[0].compareTo(r2[0]);
                    }
                } else if (isDigit1 && isDigit2) {
                    return 0;
                } else if (isDigit1) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        Arrays.sort(logs, com);
        return logs;
    }

    public static void main(String[] args) {
        ReorderLogFiles_LE_937 solution = new ReorderLogFiles_LE_937();
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        //[let1 art can, let3 art zero, let2 own kit dig, dig1 8 1 5 1, dig2 3 6]

        System.out.println(Arrays.toString(solution.reorderLogFiles(logs)));
    }
}
