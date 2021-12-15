package lintcode.colleciton.selected.phase5_stack_and_queue;

public class ComputeLastDigit_729 {
    /**
     * @param A: the given number
     * @param B: another number
     * @return: the last digit of B! / A!
     */
    //Key Idea: B! / A! = B * (B-1) * (B-2) * ... * (A + 1), get the last digit of every step
    public int computeLastDigit (long A, long B) {
        if (B == A) return 1;
        if ((B-A) >= 10) return 0; //0个连续数必有一个尾号为0

        int tmp = 1;
        for (long i = A + 1; i <= B; i++) {
            tmp = tmp * (int)(i % 10);
            tmp = tmp % 10;
            if (tmp == 0) {
                return 0;
            }
        }
        return tmp;
    }
}
