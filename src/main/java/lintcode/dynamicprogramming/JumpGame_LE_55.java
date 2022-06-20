package lintcode.dynamicprogramming;

public class JumpGame_LE_55 {
    public boolean canJump(int[] nums) {
        int local, reach = 0;
        //make sure add i <= reach check to ensure current i is reachabble
        for (int i = 0; i <= reach && i < nums.length; i++) {
            local = i + nums[i];
            reach = Math.max(local, reach);
        }
        return reach < nums.length - 1 ? false : true;
    }

    public static void main(String[] args) {
        JumpGame_LE_55 solution = new JumpGame_LE_55();
        int[] nums = {3,2,1,0,4}; //false

        System.out.println(solution.canJump(nums));
    }
}
