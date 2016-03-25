package realworld.amazon.ota.perfectnumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 3/25/16 12:32 AM
 */
public class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int perfectNumberCheck(int n) {
        // Check if N is perfect or not
        // Return 1 or 0
        // INSERT YOUR CODE HERE
        if (n == 1) {
            return 1;
        }

        List<Integer> products = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                products.add(i);
            }
        }

        int sum = 0;
        for (Integer i : products) {
            sum += i;
        }

        if (sum == n) {
            return 1;
        } else return 0;
    }

    public static void main(String[] args) {
        int n = 28;
        System.out.println(perfectNumberCheck(n));
    }
}