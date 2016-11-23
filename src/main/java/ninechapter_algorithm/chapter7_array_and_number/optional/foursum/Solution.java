package ninechapter_algorithm.chapter7_array_and_number.optional.foursum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 4/29/16 10:49
 */
public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public static ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        /* your code */
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return result;
        }
        Arrays.sort(numbers);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length - 3; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length - 2; j++) {
                if (j != i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int m = numbers.length - 1;
                while (k < m) {
                    int sum = numbers[i] + numbers[j] + numbers[k] + numbers[m];
                    if (sum == target) {
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[k]);
                        list.add(numbers[m]);
                        result.add(list);
                        list = new ArrayList<>();

                        k++;
                        m--;
                        while (k < m && numbers[k] == numbers[k - 1]) {
                            k++;
                        }
                        while (k < m && numbers[m] == numbers[m + 1]) {
                            m--;
                        }
                    } else if (sum < target) {
                        k++;
                    } else {
                        m--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1,0,-1,-1,-1,-1,0,1,1,1,2};
        int target = 2;

        System.out.println(fourSum(numbers, target));
    }
}
