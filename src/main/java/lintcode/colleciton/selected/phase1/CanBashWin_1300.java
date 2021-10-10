package lintcode.colleciton.selected.phase1;

public class CanBashWin_1300 {
    /**
     * @param n: an integer
     * @return: whether you can win the game given the number of stones in the heap
     */
    /*
    1+3=4；只要最后对方拿时，剩余石头数是4，则我方必赢，因为无论对方拿几，我方都能一次拿完；
题目变为：n能不能变为4，由此发现只要我们首次取n%4个石头，对方就会从4的倍数开始取（因为我们取走了余数，剩余一定被4整除），那么接下来，无论对方取几（1,2,3都不大于4），我们总能让对方一直处于4的倍数状态，直到获胜，
因此题目最终变为：n能否被4整除；如不能则我方获胜，如果能则我方失败；
     */
    public boolean canWinBash(int n) {
        // Write your code here
        return (n % 4) != 0;
    }
}
