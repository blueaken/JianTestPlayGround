package lintcode.dynamicprogramming;

public class JumpGame2_117 {
    /**
     * @param A: A list of integers
     * @return: An integer
     */
    //Idea: ref - https://blog.csdn.net/linhuanmars/article/details/21356187,
    //      其实思路和Jump Game还是类似的，只是原来的全局最优现在要分成step步最优和step-1步最优（假设当前步数是step）。
    //      当走到超过step-1步最远的位置时，说明step-1不能到达当前一步，我们就可以更新步数，将step+1。时间复杂度仍然是
    //      O(n)，空间复杂度也是O(1)。

    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        int lastReach = 0, reach = 0;
        int local, step = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > lastReach) {
                step++;
                lastReach = reach;
            }
            local = i + A[i];
            reach = Math.max(local, reach);
        }

        if (reach < A.length - 1) {
            return 0;
        } else {
            return step;
        }
    }
}
