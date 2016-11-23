package realworld.amazon.ota.wordlistorder;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 3/24/16 12:12 PM
 */
public class WordListOrder
{
    //METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int canArrangeWords(String arr[]) {
        // INSERT YOUR CODE HERE
        if (arr == null || arr.length < 2) {
            return -1;
        }

        List<String> item = new ArrayList<>();
        return rec(arr, item);
    }

    private static int rec(String[] arr, List<String> item) {
        if (item.size() == arr.length) {
            if (isValid(item)) {
                return 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (!item.contains(arr[i])) {
                item.add(arr[i]);
                if (rec(arr, item) == 1){
                    return 1;
                }
                item.remove(item.size() - 1);
            }
        }

        return -1;
    }

    private static boolean isValid (List<String> item) {
        String first = item.get(0);
        char preLast = first.charAt(first.length() - 1);
        for (int i = 1; i < item.size(); i++) {
            String current = item.get(i);
            if (current.charAt(0) != preLast) {
                return false;
            } else {
                preLast = current.charAt(current.length() - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String[] test = {"abcd", "dabc", "cdba"};
        String[] test = {"dabc","abcd", "cdba"};
        System.out.println(canArrangeWords(test));
    }

}
