package ninechapter_algorithm.chapter2_binarysearch.required.searchforrange;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 2/24/16 4:45 PM
 */
public class Solution_CleanBook_Template_NotWorking {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0){
            return result;
        }

        int ll = 0;
        int lr = nums.length - 1;
        while (ll < lr){
            int lmid = (ll + lr) / 2;
            if (nums[lmid] < target){
                ll = lmid + 1;
            }else {
                lr = lmid;
            }
        }

        int rl = 0;
        int rr = nums.length - 1;
        while (rl <= rr){
            int rmid = (rl + rr) / 2;
            if (nums[rmid] <= target){
                rl = rmid + 1;
            }else {
                rr = rmid - 1;
            }
        }

        if (ll <= rr){
            result[0] = ll;
            result[1] = rr;
        }
        return result;
    }

    public static void main(String[] args){
        int[] test = {5, 7, 7, 8, 8, 10};
        int target = 8;

//        int[] test = {1};
//        int target = 1;

        System.out.println(Arrays.toString(searchRange(test, target)));
    }

}
