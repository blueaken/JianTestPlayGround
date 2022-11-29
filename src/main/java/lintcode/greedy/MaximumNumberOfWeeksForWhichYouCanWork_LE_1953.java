package lintcode.greedy;

public class MaximumNumberOfWeeksForWhichYouCanWork_LE_1953 {
    /**
     11.29.2022
     - a greedy type
     ref https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work/solutions/1375399/java-solution-o-n-easy-explanation/?languageTags=java
     */
    public long numberOfWeeks(int[] milestones) {
        long sum = 0;
        int max = 0;
        int n = milestones.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, milestones[i]);
            sum += milestones[i];
        }

        long rest = sum - max;
        if (rest >= max - 1) {
            return sum;
        } else {
            //max-1 is the number of the max project's gap, since rest < max-1, we need to minus the difference between them to make sure the working week is consecutive
            return sum - (max - 1 - rest);
        }
    }
}
