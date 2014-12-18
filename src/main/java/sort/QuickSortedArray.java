package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: blueaken
 * Date: 6/18/14
 * Time: 11:25 下午
 */
public class QuickSortedArray {
    public int[] sort(int[] data){
        int size = data.length;
        if (size < 2) return data;

        int pivotIndex = size/2;
        int pivotValue = data[pivotIndex];

        int leftSize = 0;
        for (int i=0; i<size; i++){
            if (data[i] < pivotValue) leftSize++;
        }

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[size - leftSize -1];
        int lind = 0;
        int rind = 0;
        for (int i=0; i<size; i++){
            if (i == pivotIndex) continue;
            if (data[i] < pivotValue) {
                leftArray[lind++] = data[i];
            }else{
                rightArray[rind++] = data[i];
            }
        }

        leftArray = sort(leftArray);
        rightArray = sort(rightArray);

        System.arraycopy(leftArray, 0, data, 0, leftArray.length);
        data[leftArray.length] = pivotValue;
        System.arraycopy(rightArray, 0, data, leftArray.length + 1, rightArray.length);

        return data;
    }

    public static void main (String[] args){
        int[] testArray = {3,45,57,23,15,39,78,22,23,23,23,23,23};
        QuickSortedArray quickSortedArray = new QuickSortedArray();

        System.out.println("array before quick sort: " + Arrays.toString(testArray));
        quickSortedArray.sort(testArray);
        System.out.println("array after quick sort: " + Arrays.toString(testArray));
    }
}
