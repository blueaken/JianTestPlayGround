package lintcode.dynamicprogramming;

public class JumpGame2_117_Tushar {
    /**
     * @param A: A list of integers
     * @return: An integer
     */
    //Idea: ref Tushar's video, similar to LIS & MaxSum Increasing Sequence
    //     - https://www.youtube.com/watch?v=cETfFsSTGJI
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        //init
        int[] res = new int[A.length];
        res[0] = 0;

        //dp
        for (int i = 1; i < A.length; i++) {
            res[i] = -1;
            for (int j = 0; j < i; j++) {
                if (j + A[j] >= i) {
                    if (res[i] == - 1 || 1 + res[j] < res[i]) {
                        res[i] = 1 + res[j];
                    }
                }
            }
        }
        return res[A.length-1] == -1 ? 0 : res[A.length-1];
    }

    public static void main(String[] args) {
        int[] input = {2,3,1,1,2,4,2,0,1,1}; //expect 4

        JumpGame2_117_Tushar solution = new JumpGame2_117_Tushar();
        System.out.println(solution.jump(input));
    }
}
