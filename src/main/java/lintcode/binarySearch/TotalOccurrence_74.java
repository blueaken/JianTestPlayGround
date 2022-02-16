package lintcode.binarySearch;

public class TotalOccurrence_74 {
    /**
     * @param A: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    //Idea: 当hit情况下标准模板只能返回有duplicates下第一个index，不能用于计算最后一个index；用线性计算代替
    public int totalOccurrence(int[] A, int target) {
        // write your code here
        if (A.length == 0) {
            return 0;
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

        if (A[start] != target) {
            return 0;
        }

        int first = start;
        while (start < A.length && A[start] == target) {
            start++;
        }

        return start - first;
    }

    public static void main(String[] args) {
//        int[] input = {1,3,3,3,3,4,5};
//        int target = 4;

//        int[] input = {1,3,3,3,3,4,5};
//        int target = 3;

        int[] input = {1,1,1};
        int target = 1;

        TotalOccurrence_74 solution = new TotalOccurrence_74();
        System.out.println(solution.totalOccurrence(input, target));
    }
}
