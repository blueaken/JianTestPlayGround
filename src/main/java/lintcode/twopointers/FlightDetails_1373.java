package lintcode.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FlightDetails_1373 {
    /**
     * @param arr: An integer array represents durations of movies
     * @param k: An integer represents the duration of the flight
     * @return: the pair of movies index with the longest total duration
     */
    public int[] FlightDetails(int[] arr, int k) {
        // write your code here
        if (arr.length < 2 || k < 30) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        Arrays.sort(arr);
        int target = k - 30;
        int left = 0, right = arr.length - 1;
        ResultType res = new ResultType (Integer.MAX_VALUE, -1, -1);

        while (left < right) {
            int sum = arr[left] + arr[right];
            int diff = target - sum;

            if (diff > 0) {
                if (diff < res.minDiff) {
                    res = new ResultType(diff, arr[left], arr[right]);
                }
                left++;
            } else if (diff == 0) {
                res = new ResultType(diff, arr[left], arr[right]);
                break;
            } else {
                right--;
            }
        }

        //ensure idx1 less than idx2
        int idx1 = map.get(res.dur1);
        int idx2 = map.get(res.dur2);
        if (idx1 > idx2) {
            int tmp = idx1;
            idx1 = idx2;
            idx2 = tmp;
        }
        return new int[] {idx1, idx2};
    }

    class ResultType {
        int minDiff;
        int dur1;
        int dur2;

        ResultType (int minDiff, int dur1, int dur2) {
            this.minDiff = minDiff;
            this.dur1 = dur1;
            this.dur2 = dur2;
        }
    }

    public static void main(String[] args) {
        int[] input = {250, 116, 365, 489, 274, 233, 329, 48};
        int k = 859;

        FlightDetails_1373 solution = new FlightDetails_1373();
        System.out.println(Arrays.toString(solution.FlightDetails(input, k)));
    }
}
