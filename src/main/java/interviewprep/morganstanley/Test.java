package interviewprep.morganstanley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianshen
 */
public class Test {
    public static void main(String[] args) {

        // Array to be divided
        int[] array = {1,1,2,3,4,5,6,7,8};
//        int[] array = {4, 4, 3, 3, 2};
        System.out.println("Original array.");
        printArray(array);

        divideArrayBasedOnMinimumDifference(array);
    }

    /**
     * This method divides array in two sublists such that difference between sum of the elements of individual sublist
     * is minimum.
     *
     * @param array , not null
     */
    private static void divideArrayBasedOnMinimumDifference(int[] array) {

        int len = array.length;

        // If length is less than 2 there is no division
        if (len < 2) {
            return;
        }
        // Sort array.
        Arrays.sort(array);

        // Array after sorting
        System.out.println("Sorted array:");
        printArray(array);

        int totalSum = sumOfArrayElements(array);
        double s1 = totalSum / 2.0;
        int halfSum = totalSum / 2;
        if (s1 > halfSum) {
            halfSum += 1;
        }

        // Lists to hold the best solution.
        List<Integer> bestSolList1 = new ArrayList<Integer>();
        List<Integer> bestSolList2 = new ArrayList<Integer>();

        int bestSolSum = 0;
        int startIndex = len - 2;
        boolean bestSolInitialized = false;

        while (startIndex >= 0) {
            // Lists to hold sub-lists
            List<Integer> subList1 = new ArrayList<Integer>();
            List<Integer> subList2 = new ArrayList<Integer>();

            // Add last element of array to list1.
            subList1.add(array[len - 1]);
            int sum = array[len - 1];

            // Add the elements from array[len-2] to array[startIndex] to
            // list2.
            for (int i = len - 2; i > startIndex; i--) {
                subList2.add(array[i]);
            }

            for (int i = startIndex; i >= 0; i--) {

                // Add element to list 1 if
                // (sum of elements of list 1) + (current element of array)
                // is less than or equal to half sum
                if (sum + array[i] <= halfSum) {
                    subList1.add(array[i]);
                    sum += array[i];
                } else { // else add element to list 2
                    subList2.add(array[i]);
                }
            }

            // Initialize best solution
            if (!bestSolInitialized) {
                bestSolSum = sum;
                bestSolInitialized = true;
            }

            if (Math.abs(sum - halfSum) <= Math.abs(bestSolSum - halfSum)) {
                bestSolList1.clear();
                bestSolList2.clear();
                bestSolList1.addAll(subList1);
                bestSolList2.addAll(subList2);
                bestSolSum = sum;
            }


            if (sum == halfSum) {
                break;
            }

            startIndex--;
        }

        System.out.println("Sub list 1:");
        printList(bestSolList1);

        System.out.println("Sub list 2:");
        printList(bestSolList2);
    }

    /***
     * Returns sum of array elements.
     *
     * @param array
     *            , not null
     * @return sum of array elements
     */
    private static int sumOfArrayElements(final int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    /**
     * Prints array.
     *
     * @param array
     *            , not null
     */
    private static void printArray(final int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Prints array.
     *
     * @param list
     *            , not null
     */
    private static void printList(final List<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
