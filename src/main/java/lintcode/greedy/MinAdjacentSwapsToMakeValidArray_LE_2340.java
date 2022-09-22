package lintcode.greedy;

public class MinAdjacentSwapsToMakeValidArray_LE_2340 {
    /*
        ref - https://leetcode.com/problems/minimum-adjacent-swaps-to-make-a-valid-array/discuss/2609124/JAVA-95-Faster-O(N)-with-explanation
        - refactor afterwards
    */
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int minPos = 0, maxPos = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] >= nums[maxPos]) { //maxPos should be rightmost, so condition is '>='
                maxPos = i;
            }

            if (nums[i] < nums[minPos]) {
                minPos = i; //minPos should be leftmost, so condition is '<' only
            }
        }

        int ret = minPos + (n - 1 - maxPos);
        //if minPos > maxPos, minus 1 step for the overlapping step
        if (minPos > maxPos) {
            ret--;
        }
        return ret;
    }
}
