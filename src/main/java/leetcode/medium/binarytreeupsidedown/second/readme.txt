top down方法太美不敢看，大概意思是和反向LINKED LIS一样，不过要增加更多的存贮中间量，因外树比linked list更复杂，更多trap。

复习了binary tree的dfs的遍历，并练习了bottom up的 dfs 方法，基本思路是对所有节点进行:

p.left = parent.right
p.right = parent

操作。注意没有要求反过来的树还保持binary search tree。