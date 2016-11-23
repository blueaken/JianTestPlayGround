package realworld.amazon.ota.waitingtimesjf;

/**
 * Author: blueaken
 * Date: 3/27/16 11:17 AM
 */
public class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static float waitingTimeSJF(int[] requestTimes, int[] durations)
    {
        // INSERT YOUR CODE HERE
        //corner case check
        if (requestTimes == null
                || durations == null
                || requestTimes.length == 0
                || durations.length == 0
                || requestTimes.length != durations.length) {
            return -1;
        }

        //init
        int processNum = durations.length;
        float totalWaitTime = 0.0f;
        boolean[] processed = new boolean[processNum];
        processed[0] = true;
        int currentTime = durations[0];
        int counter = 1;

        //build waitTimes array
        while (counter < processNum) {
            int nextProcess = getNexProcess(requestTimes, durations, processed);
            totalWaitTime += currentTime - requestTimes[nextProcess];
            currentTime += durations[nextProcess];
            processed[nextProcess] = true;
            counter ++;
        }

        //get waitTimes average
        return totalWaitTime/processNum;
    }

    private static int getNexProcess(int[] requestTimes, int[] durations, boolean[] processed) {
        int minDuration = Integer.MAX_VALUE;
        int nextProcess = 0;
        for (int i = 0; i < durations.length; i++) {
            if (processed[i]) {
                continue;
            }

            if (durations[i] < minDuration
                    || (durations[i] == minDuration && requestTimes[i] < requestTimes[nextProcess])) {
                minDuration = durations[i];
                nextProcess = i;
            }
        }

        return nextProcess;
    }

    public static void main(String[] args) {
        int[] requestTimes = {0,1,3,9};
        int[] durations = {2,1,7,5};

        System.out.println(waitingTimeSJF(requestTimes, durations));
    }
}
