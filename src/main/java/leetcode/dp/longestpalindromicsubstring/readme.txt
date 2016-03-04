用DP来做是正解，参考：
http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-i.html

还有优化存贮空间的可能：

O(n2) runtime, O(1) space – Simpler solution:
In fact, we could solve it in O(n2) time using only constant space.
We observe that a palindrome mirrors around its center. Therefore, a palindrome can be
expanded from its center, and there are only 2n – 1 such centers.
You might be asking why there are 2n – 1 but not n centers? The reason is the center of a
palindrome can be in between two letters. Such palindromes have even number of letters
(such as “abba”) and its center are between the two ‘b’s.
Since expanding a palindrome around its center could take O(n) time, the overall
complexity is O(n2).

另外还有M's算法（谁说外国人脑子简单的？）。可以达到O(N)不过面试不会有这种要求。参考：
http://www.felix021.com/blog/read.php?2040

这个题还可以变化成：Longest Palindromic Subsequence, LeetCod里没有，就不深究了。