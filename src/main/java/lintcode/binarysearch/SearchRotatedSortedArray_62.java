package lintcode.binarysearch;

public class SearchRotatedSortedArray_62 {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    //Idea:
    //1. 两分后判断哪一部分是有序的，再进行下一步两分。Ref - https://www.lintcode.com/problem/62/solution/23867, 但自己的模板对[4,3],3这个case通不过
    // 自己分析了旋转数组2分后的3种可能性，重写了比较逻辑，fix了[4,3],3这个bug
    //2. 另一个笨办法是先两分找到pivot point，再对target所在的部分进行两分
    public int search(int[] A, int target) {
        // write your code here
        if (A.length == 0) {
            return -1;
        }

        int start = 0, end = A.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] < target) {
                if ((A[mid] < A[end] && target <= A[end]) || A[mid] > A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if ((A[mid] > A[start] && target >= A[start]) || A[mid] < A[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return A[start] == target ? start : -1;

    }

    public static void main(String[] args) {
//        int[] test = {6,8,9,1,3,5};
//        int target = 8;

        int[] test = {4,3};
        int target = 4;

        SearchRotatedSortedArray_62 solution = new SearchRotatedSortedArray_62();
        System.out.println(solution.search(test, target));
    }
}
