package lintcode.binarySearch;

public class ClosestNumber_459 {
    /**
     * @param A: an integer array sorted in ascending order
     * @param target: An integer
     * @return: an integer
     */
    //Idea: 注意标准模板当miss时, start和end都停留在比target大一点的位置，需要处理
    public int closestNumber(int[] A, int target) {
        // write your code here
        if (A.length == 0) {
            return -1;
        }


        int start = 0, end = A.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        int diff1 = Math.abs(A[start] - target);
        int diff2 = Integer.MAX_VALUE;
        if (start > 0) {
            diff2 = Math.abs(A[start-1] - target);
        }
        return diff1 < diff2 ? start : start-1;
    }

    public static void main(String[] args) {
        int[] input = {1,4,6,8};
        int target = -9;

        ClosestNumber_459 solution = new ClosestNumber_459();
        System.out.println(solution.closestNumber(input,target));
    }
}
