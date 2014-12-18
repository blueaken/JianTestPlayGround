package merge;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: blueaken
 * Date: 6/22/14
 * Time: 10:57 下午
 */
public class MergeSortedInPlaceArray {
    /**
     * Analysis: solution 1 - using an extra array. Simple but need extra memory.
     * So let's try solution 2 - merge sort from the end and finish the task in place
     */
    public static void merge(int A[], int m, int B[], int n) {
            int position = m+n-1;
            m--;n--;

            while (m>=0 && n>=0){
                if(A[m] > B[n]){
                    A[position--] = A[m--];
                } else{
                    A[position--] = B[n--];
                }
            }

            while (n>=0){
                A[position--] = B[n--];
            }
    }

    public static void main(String[] args){
        //assume array testA has size of m+n
        int[] testA = {1,3,5,7,9,11,0,0,0,0};
        int[] testB = {2,4,6,8};

        System.out.println("testA array before merge: " + Arrays.toString(testA));
        merge(testA, 6, testB, 4);
        System.out.println("testA array after merge: " + Arrays.toString(testA));

        //null testB case
        int[] twoA = {1,3};
        int[] nullB = {};
        System.out.println("testA array before merge: " + Arrays.toString(twoA));
        merge(twoA, 2, nullB, 0);
        System.out.println("testA array after merge: " + Arrays.toString(twoA));

    }
}
