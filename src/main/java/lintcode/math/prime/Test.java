package lintcode.math.prime;

import java.util.*;

public class Test {

    /**
     11.12.23
     ref this solution post and its comments - https://leetcode.com/problems/maximum-swap/solutions/107068/java-simple-solution-o-n-time/
     */
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int n = arr.length;

        int[]ple = new int[n];
        ple[0] = arr[0];
        for (int i = 1; i < n; i++) {
            ple[i] = Math.min(arr[i], ple[i-1]);
        }

        int[]nge = new int[n];
        nge[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            nge[i] = Math.max(arr[i], nge[i+1]);
        }

        int minPos = -1;
        for (int i = 0; i < n; i++) {
            if (ple[i] >= nge[i]) {
                continue;
            }
            minPos = i;
            break;
        }

        // no swap need
        if (minPos == -1) {
            return num;
        }

        int maxPos = minPos;
        while (maxPos < n-1 && nge[maxPos] == nge[maxPos+1]) {
            maxPos++;
        }

        // swap
        char temp = arr[maxPos];
        arr[maxPos] = arr[minPos];
        arr[minPos] = temp;

        String res = new String(arr);
        return Integer.valueOf(res);
    }


    public static void main(String[] args) {
        Test test = new Test();

//        int n = 9936;//9963
//        int n = 99228; //99822
        int n = 9973;
        System.out.println(test.maximumSwap(n));
    }
}


