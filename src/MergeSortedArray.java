import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: blueaken
 * Date: 6/18/14
 * Time: 10:21 下午
 */
public class MergeSortedArray {

    public int[] sort(int[] data){
        int size = data.length;
        if (size<2) return data;
        int mid = size/2;
        int[] leftArray = Arrays.copyOfRange(data, 0, mid);
        int[] rightArray = Arrays.copyOfRange(data, mid, size);

        sort(leftArray);
        sort(rightArray);

        return merge(data, leftArray, rightArray);
    }

    private int[] merge(int[]data, int[]leftArray, int[]rightArray){
        int ind=0;
        int lind=0;
        int rind=0;

        while(lind < leftArray.length && rind < rightArray.length){
            if (leftArray[lind] < rightArray[rind]){
                data[ind++] = leftArray[lind++];
            } else {
                data[ind++] = rightArray[rind++];
            }
        }

        while (lind < leftArray.length){
            data[ind++] = leftArray[lind++];
        }

        while (rind < rightArray.length){
            data[ind++] = rightArray[rind++];
        }

        return data;
    }

    public static void main(String[] args){
        int[] testArr = {3,45,57,23,15,39,78,22,23};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        System.out.println("before merge sort the array is: " + Arrays.toString(testArr));
        mergeSortedArray.sort(testArr);
        System.out.println("after merge sort the array is: " + Arrays.toString(testArr));
    }

}
