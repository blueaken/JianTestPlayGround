package lintcode.dynamicprogramming2;

public class FindNumberOfLIS_1093 {
    /**
     * @param nums: an array
     * @return: the number of longest increasing subsequence
     */
    //Idea: another variant of Longest Increasing Variant, similar to
    //      Longest Mountain Array
    //Ref - https://www.lintcode.com/problem/1093/solution/28166
    //    & Tushor's Longest Mountain Array video
    public int findNumberOfLIS(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //init
        int[] lis = new int[nums.length];
        int[] count = new int[nums.length];
        lis[0] = 1;
        count[0] = 1;

        //dp
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            lis[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lis[i] == lis[j] + 1) {
                        //find a new path of current max length, combine the count
                        count[i] += count[j];
                    } else if (lis[i] < lis[j] + 1) {
                        //find a new max length path
                        lis[i] = lis[j] + 1;
                        count[i] = count[j];
                        maxLen = Math.max(maxLen, lis[i]);
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < lis.length; i++) {
            if (lis[i] == maxLen) {
                result += count[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {1,3,5,4,7}; //expect 2
//        int[] input = {2,2,2}; //expect 3;

        FindNumberOfLIS_1093 solution = new FindNumberOfLIS_1093();
        System.out.println(solution.findNumberOfLIS(input));
    }
}
