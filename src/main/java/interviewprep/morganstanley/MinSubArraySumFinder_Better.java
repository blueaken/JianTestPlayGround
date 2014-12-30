package interviewprep.morganstanley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * @author jianshen
 */
public class MinSubArraySumFinder_Better {
    public static void main(String[] args){
//        int[] input = {4, 4, 3, 3, 2};
        int[] input = {1,1,2,3,4,5,6,7,8};
        findMinSumDiffSubArray(input);
    }

    private static void findMinSumDiffSubArray(int[] data){
        int len = data.length;
        if (len < 2) {
            System.out.println("Size less than 2, cannot divide the input array.");
            return;
        }

        Arrays.sort(data);
        System.out.println("Sorted input array:");
        printArray(data);

        List<Integer> bestSubArr1 = new ArrayList<Integer>();
        List<Integer> bestSubArr2 = new ArrayList<Integer>();

        boolean initialized = false;
        int bestSubArrSum1 = 0;

        int totalSum = getArraySum(data);
        double s1 = totalSum / 2.0;
        int halfSum = totalSum / 2;
        //adjust halfSum val if more than the integer value
        if (s1 > halfSum) {
            halfSum += 1;
        }


        int start = len - 2;
        while (start>=0){
            BitSet bitSet = new BitSet();
            List<Integer> tempSubArr1 = new ArrayList<Integer>();
            List<Integer> tempSubArr2 = new ArrayList<Integer>();
            tempSubArr1.add(data[len-1]);
            int tempSum1 = data[len-1];
            bitSet.set(len-1);

            for (int i=start; i>=0; i--){
                if (tempSum1 + data[i] <= halfSum){
                    tempSubArr1.add(data[i]);
                    tempSum1 += data[i];
                    bitSet.set(i);
                }
            }

            //add the rest
            for (int i=0; i<len; i++) {
                if(!bitSet.get(i))
                tempSubArr2.add(data[i]);
            }

            if (!initialized){
                bestSubArr1 = tempSubArr1;
                bestSubArr2 = tempSubArr2;
                bestSubArrSum1 = tempSum1;
                initialized = true;
            }

            if (Math.abs(halfSum - tempSum1) < Math.abs(halfSum - bestSubArrSum1)){
                bestSubArr1.clear();
                bestSubArr1.addAll(tempSubArr1);
                bestSubArr2.clear();
                bestSubArr2.addAll(tempSubArr2);
                bestSubArrSum1 = tempSum1;
            }

            if (bestSubArrSum1 == halfSum) {
                break;
            }

            start--;
        }

        System.out.println("Divided sub array 1:");
        printList(bestSubArr1);

        System.out.println("Divided sub array 2:");
        printList(bestSubArr2);

    }

    private static void printArray(final int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void printList(final List<Integer> list){
        for (int i : list){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int getArraySum(final int[] data){
        int sum = 0;
        for (int i=0; i<data.length; i++){
            sum += data[i];
        }
        return sum;
    }
}
