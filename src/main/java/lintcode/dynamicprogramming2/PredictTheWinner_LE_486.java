package lintcode.dynamicprogramming2;

public class PredictTheWinner_LE_486 {
    //Ref - https://www.youtube.com/watch?v=WxpIHvsu1RI
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        //init
        Record[][] rec = new Record[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                rec[i][j] = new Record();
                if (i == j) {
                    rec[i][j].one = nums[i]; //len = 1 cases
                }
            }
        }

        //dp
        for (int len = 2; len <= nums.length; len++) {
            for (int i = 0; i < nums.length - len + 1; i++) {
                int j = i + len - 1;

                if (nums[i] + rec[i+1][j].two >= nums[j] + rec[i][j-1].two) {
                    rec[i][j].one = nums[i] + rec[i+1][j].two;
                    rec[i][j].two = rec[i+1][j].one;
                } else {
                    rec[i][j].one = nums[j] + rec[i][j-1].two;
                    rec[i][j].two = rec[i][j-1].one;
                }
            }
        }

        return rec[0][nums.length-1].one >= rec[0][nums.length-1].two;
    }

    public static void main(String[] args) {
        int[] input = {3,9,1,2}; //expect 11,4, true

        PredictTheWinner_LE_486 solution = new PredictTheWinner_LE_486();
        System.out.println(solution.PredictTheWinner(input));
    }
}

class Record {
    int one;
    int two;
}
