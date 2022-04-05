package lintcode.dynamicprogramming2;

import java.util.Arrays;

public class WeightedJobSchedulingMaximumProfit_LE_1235 {

    //Idea: inspired by Tushor's video - https://www.youtube.com/watch?v=cr6Ip0J9izc
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] job = new int[n][3];
        for (int i = 0; i < n; i++) {
            job[i][0] = startTime[i];
            job[i][1] = endTime[i];
            job[i][2] = profit[i];
        }
        //sort by endTime
        Arrays.sort(job, (a1, a2) -> a1[1] - a2[1]);
        int[] res = new int[n];
        res[0] = job[0][2];
        for (int i = 0; i < n; i++) {
            res[i] = job[i][2];
        }

        for (int end = 1; end < n; end++) {
            res[end] = Math.max(job[end][2], res[end-1]);
            //start job from reverse order to improve time performance
            for(int start = end - 1; start >=0; start--){
                if (isNotOverlap(job[start], job[end])) {
                    res[end] = Math.max(res[end], job[end][2] + res[start]);
                    break;
                }
            }
        }

        return res[n-1];
    }

    private boolean isNotOverlap (int[] startJob, int[] endJob) {
        return startJob[1] <= endJob[0];
    }

    public static void main(String[] args) {
        //expect 17
        int[] startTime = {1,2,4,6,5,7};
        int[] endTime = {3,5,6,7,8,9};
        int[] profit = {5,6,5,4,11,2};

//        //expect 6
//        int[] startTime = {1,1,1};
//        int[] endTime = {2,3,4};
//        int[] profit = {5,6,4};

//        //expect 18
//        int[] startTime = {4,2,4,8,2};
//        int[] endTime = {5,5,5,10,8};
//        int[] profit = {1,2,8,10,4};

        WeightedJobSchedulingMaximumProfit_LE_1235 solution = new WeightedJobSchedulingMaximumProfit_LE_1235();
        System.out.println(solution.jobScheduling(startTime,endTime,profit));
    }
}
