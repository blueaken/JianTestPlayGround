package sort;

import java.util.Arrays;

/**
 * @author jianshen
 */
public class InsertSortedArray {
    public static void insertSort(int[] num){
        int len = num.length;
        int swap;
        for (int i=1; i<len; i++){
            for (int j=i; j>0; j--){
                if (num[j-1] > num[j]) {
                    swap = num[j]; num[j] = num[j-1]; num[j-1] = swap;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {2,4,1,10,6,8,5};
//        int[] arr = {2};
        System.out.println("before insert sort, the array is: " + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("after insert sort, the array is:  " + Arrays.toString(arr));
    }
}
