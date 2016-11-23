package realworld.microsoft.prep.meetingroom;

/**
 * Author: blueaken
 * Date: 2/18/16 9:30 AM
 */
public class Solution {
    public static int calcMeetingRoom(int starttime[], int endtime[]){
        if (starttime == null || endtime == null) return 0;

        int num = 0, max = 0;
        int i = 0;
        int j = 0;

        while (i<starttime.length-1 && j<endtime.length-1) {
            if (starttime[i] < endtime[j]){
                num++;
                i++;
                if (num>max){
                    max = num;
                }
            } else{
                num--;
                j++;
            }

        }

        return max;
    }

    public static void main(String[] args){
        int starttime[] = {900, 940, 950, 1100, 1500, 1800};
        int endtime[] = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println("Minimum Number of Meeting Rooms Required = " + calcMeetingRoom(starttime, endtime));
    }
}
