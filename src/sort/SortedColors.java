package sort;

import java.util.Arrays;

/**
 * @author jianshen
 */
public class SortedColors {
    public static void sortColors(int[] A) {
        int arrLen = A.length;

        int p0=0, p2=arrLen-1;
        int cur=0;
        while (cur<=p2){
            while (p0<arrLen-1 && A[p0]==0) p0++;
            while (p2>0 && A[p2]==2) p2--;
            if (p0==p2) break;

            if (A[cur] == 2){
                A[cur] = A[p2]; A[p2] = 2;
                p2--; //move p2 to the next position for '2' to copy
            }

            if (A[cur] == 0){
                A[cur] = A[p0]; A[p0] = 0;
                p0++; //move p0 to the next position for '0' to copy
            }

            cur++;

        }
    }

    public static void main(String[] args){
        int[] arr = {1};
        System.out.println("before sort the color object array is: " + Arrays.toString(arr));
        sortColors(arr);
        System.out.println("after sort the color object array is: " + Arrays.toString(arr));
    }
}
