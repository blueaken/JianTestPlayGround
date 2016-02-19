Ref Code Ganker: http://blog.csdn.net/linhuanmars/article/details/21570835

这个题跟Permutations非常类似，唯一的区别就是在这个题目中元素集合可以出现重复。这给我们带来一个问题就是如果不对重复元素加以区别，那么类似
于{1,1,2}这样的例子我们会有重复结果出现。那么如何避免这种重复呢？方法就是对于重复的元素循环时跳过递归函数的调用，只对第一个未被使用的进行
递归，我们那么这一次结果会出现在第一个的递归函数结果中，而后面重复的会被略过。如果第一个重复元素前面的元素还没在当前结果中，那么我们不需要
进行递归。想明白了这一点，代码其实很好修改。


这样的解法是带有一般性的，把这个代码放到Permutations中也是正确的，所以如果熟悉的话，面试时如果碰到这个题目建议直接实现这个代码，不要假设
元素没有重复，当然可以跟面试官讨论，不过一般来说都是要考虑这个情况的哈。

SJ: one bug on Code Ganker's code is it need sort the original array before call recursive, otherwise how to tell if
the previous element is a duplicate?
