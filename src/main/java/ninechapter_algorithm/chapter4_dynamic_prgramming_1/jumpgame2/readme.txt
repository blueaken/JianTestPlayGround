参考一下CG的大作：
http://blog.csdn.net/linhuanmars/article/details/21356187

这道题是Jump Game的扩展，区别是这道题不仅要看能不能到达终点，而且要求到达终点的最少步数。其实思路和Jump Game还是类似的，只是原来的全局
最优现在要分成step步最优和step-1步最优（假设当前步数是step）。当走到超过step-1步最远的位置时，说明step-1不能到达当前一步，我们就可以
更新步数，将step+1。时间复杂度仍然是O(n)，空间复杂度也是O(1)。

全局最优和局部最优的思路，类似的还有Maximum SubArray，MaxProduct SubArray

========

nine chapter class notes － 最好不要学贪心，每道题都不一样，没有规律

f[i] = MIN{f[j]+1, j < i && j能够跳到i}