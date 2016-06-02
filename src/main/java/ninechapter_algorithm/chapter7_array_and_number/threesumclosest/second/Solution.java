package ninechapter_algorithm.chapter7_array_and_number.threesumclosest.second;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 5/25/16 09:48
 */
class Result {
    int minDiff;
    int sum;
    Result(int minDiff, int sum) {
        this.minDiff = minDiff;
        this.sum = sum;
    }
}

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        Result result = new Result(Integer.MAX_VALUE, Integer.MAX_VALUE);
        if (numbers == null || numbers.length < 3) {
            return result.sum;
        }

        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            //in case numbers[i] duplicates
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = numbers.length - 1;
            while (j < k) {
                int sum = numbers[i] + numbers[j] + numbers[k];
                int diff = sum - target;
                if (diff == 0) {
                    return target;
                } else if (diff > 0) {
                    k--;
                } else {
                    j++;
                }
                //record the sum when diff is minimum
                if (Math.abs(diff) < result.minDiff) {
                    result.minDiff = Math.abs(diff);
                    result.sum = sum;
                }
            }
        }
        return result.sum;
    }
}