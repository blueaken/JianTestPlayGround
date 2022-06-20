package lintcode.dynamicprogramming;

public class JumpGame2_LE_45 {
    //ref previous notes
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int size = nums.length;
        int[] res = new int[size];
        res[0] = 0; //no way to jump to 1st position
        for (int i = 1; i < size; i++) {
            res[i] = -1;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) { //if reachable
                    if (res[i] == -1 || 1 + res[j] < res[i]) {
                        res[i] = 1 + res[j];
                    }
                }
            }
        }
        return res[size-1];
    }
}
