package lintcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_57 {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return res;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i !=0 && numbers[i] == numbers[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = numbers.length - 1;
            while (j < k) {
                int sum = numbers[i] + numbers[j] + numbers[k];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(numbers[i]);
                    list.add(numbers[j]);
                    list.add(numbers[k]);
                    res.add(list);

                    while (j < k && numbers[j] == numbers[j+1]) {
                        j++;
                    }
                    j++;
                    while (j < k && numbers[k] == numbers[k-1]) {
                        k--;
                    }
                    k--;
                } else if (sum < 0) {
                    while (j < k && numbers[j] == numbers[j+1]) {
                        j++;
                    }
                    j++;
                } else {
                    while (j < k && numbers[k] == numbers[k-1]) {
                        k--;
                    }
                    k--;
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {2,7,11,15};
//        int[] input = {1,0,-1,-1,-1,-1,0,1,1,1};

        ThreeSum_57 solution = new ThreeSum_57();
        System.out.println(solution.threeSum(input).toString());
    }
}
