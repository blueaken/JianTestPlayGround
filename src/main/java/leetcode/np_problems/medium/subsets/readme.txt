ref: http://blog.csdn.net/linhuanmars/article/details/24286377

求子集问题是经典的NP问题，复杂度上我们就无法强求了哈，肯定是非多项式量级的。一般来说这个问题有两种解法：递归和非递归。
我们先来说说递归解法，主要递推关系就是假设函数返回递归集合，现在加入一个新的数字，我们如何得到包含新数字的所有子集。其实就是在原有的集合中
对每集合中的每个元素都加入新元素得到子集，然后放入原有集合中（原来的集合中的元素不用删除，因为他们也是合法子集）。而结束条件就是如果没有元
素就返回空集（注意空集不是null，而是没有元素的数组）就可以了。时间和空间都是取决于结果的数量，也就是O(2^n)

SJ: marin software hit a similar question for phone numbers.

inspired by the recursive solution I wrote the iterative solution for the same base idea. And the recursive solution.