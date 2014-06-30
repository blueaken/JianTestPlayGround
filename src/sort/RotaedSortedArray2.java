package sort;

/**
 * Author: blueaken
 * Date: 6/29/14 5:50 下午
 */

//使用了万能的递归解法，更喜欢水中的鱼的评论和解法：http://fisherlei.blogspot.com/2013/01/leetcode-search-in-rotated-sorted-array_3.html
public class RotaedSortedArray2 {
    public static boolean search(int[] A, int target) {
        return rec(A, 0, A.length-1, target);
    }

    private static boolean rec(int[] A, int start, int end, int target) {
        if (start > end) return false; //if missed return not found

        int mid = start + (end - start)/2;
        if (target == A[mid]) return true;
        boolean isFound = rec (A, start, mid-1, target); //binary search left side first
        if (!isFound) return rec(A, mid+1, end, target); //if missed binary search right side
        return true;
    }

    public static void main(String[] args){
        int[] rotatedArr = {3,4,4,5,5,6,7,9,0,1,2};
        int target = 7;
        boolean isFound = search(rotatedArr, target);
        System.out.println("target " + target + " is in the rotated array is: " + isFound);

    }
}
