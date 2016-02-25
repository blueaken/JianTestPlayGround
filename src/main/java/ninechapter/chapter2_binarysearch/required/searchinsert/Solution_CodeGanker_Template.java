package ninechapter.chapter2_binarysearch.required.searchinsert;

/**
 * Author: blueaken
 * Date: 2/24/16 5:12 PM
 */
public class Solution_CodeGanker_Template {
    public static int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0)
        {
            return 0;
        }
        int l = 0;
        int r = A.length-1;
        while(l<=r)
        {
            int mid = (l+r)/2;
//            if(A[mid]==target)
//                return mid;
            if(A[mid]<target)
                l = mid+1;
            else
                r = mid-1;
        }
        return l;
    }

    public static void main(String[] args){
        int[] test = {1,3,5,6};

//        int target = 5;

//        int target = 2;

//        int target = 7;

        int target = 0;

        System.out.println(searchInsert(test, target));
    }
}
