package level5;

/**
 * Author: blueaken
 * Date: 2/10/15 8:43 下午
 */
//https://oj.leetcode.com/problems/maximum-gap/
//ref - http://blog.csdn.net/u012162613/article/details/41936569
// to be finished
public class MaximumGapFinder_LinerComplexity {
    public static void main(String[] args){
        int[] data = {4, 32, 21, 2, 56, 14};
        System.out.println("max gap is: " + maximumGap(data));
    }

    public static int maximumGap(int[] num) {
        if (num.length < 2) return 0;


        int maxGap =0;
        for (int i=1; i<num.length; i++){
            maxGap = Math.max(maxGap, num[i] - num[i-1]);
        }

        return maxGap;
    }
}
