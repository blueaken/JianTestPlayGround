/**
 * Created with IntelliJ IDEA.
 * User: blueaken
 * Date: 6/22/14
 * Time: 10:57 下午
 */
public class MergeSortedInPlaceArray {
    // solution 1 - using an extra array. Simple but need extra memory
    // try solution 2 - sort from the end and finish the task in place
    public static void merge(int A[], int m, int B[], int n) {
        if ((A == null || A.length == 0) && (B != null && B.length != 0)) {
            System.arraycopy(B, 0, A, 0, B.length);
            return;
        }

        int[] result = new int[m+n];
        int position = 0;
        int aposition = 0;
        int bposition = 0;

        while (aposition < A.length && bposition < B.length){
            if (A[aposition] < B[bposition]){
                result[position++] = A[aposition++];
            }else{
                result[position++] = B[bposition++];
            }
        }

        while (aposition < A.length){
            result[position++] = A[aposition++];
        }

        while (bposition < B.length){
            result[position++] = B[bposition++];
        }

        System.arraycopy(result, 0, A, 0, result.length);
    }
}
