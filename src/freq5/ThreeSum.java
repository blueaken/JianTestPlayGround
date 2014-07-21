package freq5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 7/19/14 11:17 下午
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] num) {
        //prepare step
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = num.length;
        if (len < 3) {
            return result;
        }
        Arrays.sort(num);

        //start procession
        for (int i=0; i<len-2; i++){    //left index
            if(i>0){                    //skip duplicate left values
                if (num[i] == num[i-1]) continue;
            }

            int j=i+1;                  //middle index
            int k=len-1;                //right index
            int tripleSum;
            while(j<k){
                tripleSum = num[i] + num[j] + num[k];
                if (tripleSum<0){
                    j = moveMiddleIndex(j,k,num);
                } else if(tripleSum>0){
                    k = moveRightIndex(j,k,num);
                } else {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[j]);
                    temp.add(num[k]);
                    result.add(temp);
                    j = moveMiddleIndex(j,k,num);
                    k = moveRightIndex(j,k,num);
                }
            }
        }

        //return result
        return result;
    }

    private static int moveMiddleIndex(int middleIndex, int rightIndex, int[] num){
        middleIndex++;
        while (middleIndex < rightIndex && num[middleIndex] == num[middleIndex-1]){  //skip duplicate middle values
            middleIndex++;
        }
        return middleIndex;
    }

    private static int moveRightIndex(int middleIndex, int rightIndex, int[] num){
        rightIndex--;
        while (rightIndex > middleIndex && num[rightIndex] == num[rightIndex+1]){    //skip duplicate right values
            rightIndex--;
        }
        return rightIndex;
    }

    public static void main(String[] args){
        int[] test = {-1,0,1,2,-1,4};
        List<List<Integer>> result = threeSum(test);
        System.out.println(result.toString());
    }
}
