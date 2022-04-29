package lintcode.prefixsum;

//similar to 665, much simpler though
public class RangeSumQuery_943 {
    int[] prefixSum;

    public RangeSumQuery_943(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = nums[i-1] + prefixSum[i-1];
        }
        this.prefixSum = prefixSum;
    }

    public int sumRange(int i, int j) {
        //convert to prefixSum base
        i++;j++;

        return prefixSum[j] - prefixSum[i-1];
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};

        RangeSumQuery_943 solution = new RangeSumQuery_943(input);
        System.out.println(solution.sumRange(2,4)); //12
    }
}
