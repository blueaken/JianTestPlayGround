import java.util.Arrays;

/**
 * @author jianshen
 */
public class QuickSort_Simple {

    public static void main (String[] args){
        int[] array = {3,45,57,23,15,39,78,22,23,23,23,23,23};
//        int[] array = {57,45,3,3};

        System.out.println("array before merge sort: " + Arrays.toString(array));
        System.out.println("array after merge sort: " + Arrays.toString(quickSort(array)));
    }

    static int[] quickSort(int[] arr) {
        if (arr.length > 1) {
            int midIndex = arr.length/2;
            int pivotValue = arr[midIndex];

            int lCount = 0;
            for (int i=0;i<arr.length;i++){
                if (arr[i] < pivotValue){
                    lCount++;
                }
            }

            int[] leftArray = new int[lCount];
            int[] rightArray = new int[arr.length - lCount -1];
            int li=0;
            int ri=0;
            for (int i=0;i<arr.length;i++){
                if( i == midIndex ) continue;

                if (arr[i] < pivotValue){
                    leftArray[li++] = arr[i];
                }
                if (arr[i] >= pivotValue){
                    rightArray[ri++] = arr[i];
                }
            }
            leftArray = quickSort(leftArray);
            rightArray = quickSort(rightArray);

            System.arraycopy(leftArray, 0, arr, 0, leftArray.length);
            arr[leftArray.length] = pivotValue;
            System.arraycopy(rightArray, 0, arr, leftArray.length+1, rightArray.length);

            return arr;
        }else{
            return arr;
        }
    }

}
