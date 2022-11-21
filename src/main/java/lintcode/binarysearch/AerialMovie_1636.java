package lintcode.binarysearch;

import java.util.Arrays;

public class AerialMovie_1636 {
    /**
     * @param t: the length of the flight
     * @param dur: the length of movies
     * @return: output the lengths of two movies
     */
    //Idea: 数组排序后从大到小开始二分查找，可以不用再判断同等时长下选择最大片长的问题
    public int[] aerialMovie(int t, int[] dur) {
        // Write your code here
        if (t <= 30 || dur == null || dur.length < 2) {
            return new int[2];
        }

        int[] res = new int[2];
        Arrays.sort(dur);

        t -= 30;
        int cur = Integer.MIN_VALUE;

        for (int i = dur.length - 1; i >= 1; i--) {
            int candidate = find(dur, t - dur[i], i - 1);
            if (candidate <= t - dur[i] && candidate + dur[i] > cur) {
                cur = candidate + dur[i];
                res[0] = candidate;
                res[1] = dur[i];
            }

        }
        return res;
    }

    private int find (int[] dur, int target, int end) {
        int start = 0;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (dur[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        //in case of miss, return the one just exact lower than target
        if (dur[start] == target) {
            return dur[start];
        } else {
            return start > 0 ? dur[start-1] : dur[0];
        }
    }

    public static void main(String[] args) {
//        int t = 87;
//        int[] dur = {20,25,19,37};

        int t = 127;
        int[] dur = {50,17,46,42,22,28,13,12,54,52,19,12};

        AerialMovie_1636 solution = new AerialMovie_1636();
        System.out.println(Arrays.toString(solution.aerialMovie(t, dur)));
    }
}
