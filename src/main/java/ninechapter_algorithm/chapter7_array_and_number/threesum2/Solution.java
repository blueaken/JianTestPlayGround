package ninechapter_algorithm.chapter7_array_and_number.threesum2;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 4/28/16 9:45 AM
 */
public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public static int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        if (numbers == null || numbers.length < 3) {
            return -1;
        }

        Arrays.sort(numbers);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i != 0 && numbers[i] == numbers[i-1]) {
                continue;
            }
            int start = i + 1;
            int end = numbers.length - 1;
            while (start < end) {
                int sum = numbers[i] + numbers[start] + numbers[end];
                int diff = sum - target;
                if (diff == 0) {
                    return target;
                } else {
                    if (Math.abs(diff) < Math.abs(minDiff)){
                        minDiff = diff;
                    }
                    if (diff < 0) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return minDiff + target;
    }

    public static void main(String[] args) {
        int[] numbers = {1,0,-1,-1,-1,-1,0,1,1,1,2};
        int target = 7;

        System.out.println(threeSumClosest(numbers, target));
    }
}
