package sort;

import java.util.Arrays;

/**
 * @author jianshen
 */
public class SortedColors {
    public static void sortColors(int[] A) {
        //since required only one pass, considering using 2 pointers front and back
        int arrLen = A.length;

        int p0=0, p2=arrLen-1;

        while (p0<arrLen-1 && A[p0]==0) {p0++;}
        while (p2>0 && A[p2]==2) p2--;

        int cur=p0;
        while (cur<=p2){
            if (A[cur]==0 && cur>p0) {
                A[cur] = A[p0]; A[p0] = 0;
                p0++;
                continue;
            }

            if (A[cur]==2) {
                A[cur] = A[p2]; A[p2] = 2;
                p2--;
                continue;
            }

            cur++;
        }

    }

    public static void main(String[] args){
//        int[] arr = {0,2,1,0,1,2,2,1,2,1,0,0,2,2,2,0,1,0,1,2,2,2,0,2,2,2,2,1,2,1,0,0,2,1,0,1,0,0,0,1,1,0};
        int[] arr = {2};
        System.out.println("before sort the color object array is: " + Arrays.toString(arr));
        sortColors(arr);
        System.out.println("after sort the color object array is:  " + Arrays.toString(arr));
    }
}
