package lintcode.dynamicprogramming;

public class JumpGame_116 {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    //Idea: 参考CG的文章，用local/global最优解来试试, ref - https://blog.csdn.net/linhuanmars/article/details/21354751
    public boolean canJump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return false;
        }

        int local = 0;
        int reach = 0;
        //加上i < reach条件确保当前节点是可以到达的
        for (int i = 0; i <= reach && i < A.length; i++) {
            //local维护从当前节点出发所能到的最远距离
            local = i + A[i];
            //reach(global)维护目前为止能跳到的最远距离
            reach = Math.max(local, reach);
        }

        return reach < A.length - 1 ? false : true;
    }

    public static void main(String[] args) {
        int[] A = {4,6,9,5,9,3,0};
//        int[] A = {0,8,2,0,9};

        JumpGame_116 solution = new JumpGame_116();
        System.out.println(solution.canJump(A));
    }
}
