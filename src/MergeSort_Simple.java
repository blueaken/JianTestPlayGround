import java.util.Arrays;

/**
 * @author jianshen
 */
public class MergeSort_Simple {

    public static void main (String[] args){
        int[] array = {3,45,57,23,15,39,78,22,23};
//        int[] array = {57,45,3};

        System.out.println("array before merge sort: " + Arrays.toString(array));
        System.out.println("array after merge sort: " + Arrays.toString(mergeSort(array)));
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length/2;

            int[] leftArray = Arrays.copyOfRange(arr, 0, mid);
            int[] rightArray = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(leftArray);
            mergeSort(rightArray);

            return merge(arr, leftArray, rightArray);
        }else{
            return arr;
        }
    }

    private static int[] merge(int[] arr, int[] leftArray, int[] rightArray){
        int ind=0;
        int lind=0;
        int rind=0;

        while (lind < leftArray.length && rind < rightArray.length){
            if (leftArray[lind] < rightArray[rind]){
                arr[ind++] = leftArray[lind++];
            }else{
                arr[ind++] = rightArray[rind++];
            }
        }

        while (lind < leftArray.length){
            arr[ind++] = leftArray[lind++];
        }

        while (rind < rightArray.length){
            arr[ind++] = rightArray[rind++];
        }

        return arr;
    }
}
