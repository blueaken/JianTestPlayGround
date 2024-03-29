package lintcode.binarytree;

import type.TreeNode;

public class BuildBinaryExpressionTreeFromInfixExpression_LE_1597_Rec {
    /*
        - previously convert to postfix first, this time try to solve it directly
        - ref Huifeng Guan's code
        - Basic idea is recursive, 最后的边界条件就是表达式的长度为1，说明就是一个数字，那么直接以其建立叶子节点并返回
        - 最外层必然是加减法。所以从后往前搜寻第一个不在括号内的加号或者减号。然后以该运算符为根节点，将整个字符串就分为前后两部分，分别递归生成它的左右节点。
        - 如何避免搜到包含在括号内的加减号呢？我们遇到第一个最外层的右括号的时候，就开启括号匹配模式。用一个计数器来统计未匹配的右括号，直至计数器恰好变为0，那么说明这一对最外层括号找齐了，那么从此之后恢复寻找第一个加减号的模式。
        - 上面的one pass结束之后如果没有进入下一层，说明表达式中没有括号外的加减号。那么重复上述的过程，目标改为从后往前搜寻第一个不在括号内的乘号或者除号。然后以该运算符为根节点，将整个字符串就分为前后两部分，分别递归生成它的左右节点。
        - 如果上面的one pass结束之后仍然没有进入下一层，那么就说明这个表达式本身就是被一对括号包裹着。那么我们将这对括号脱去，递归处理里面的字符串就行了
    */
    public TreeNode expTree(String s) {
        int n = s.length();
        if (n ==  1) {
            TreeNode root = new TreeNode(s.charAt(0));
            return root;
        }

        for (int i = n - 1; i >= 0; i--) {
            char cur = s.charAt(i);
            if (cur == '+' || cur == '-') {
                TreeNode root = new TreeNode(cur);
                root.right = expTree(s.substring(i+1));
                root.left = expTree(s.substring(0, i));
                return root;
            } else if (cur == ')') {
                int j = i - 1;
                int count = 1;
                while(j >= 0 && count > 0) {
                    if (s.charAt(j) == ')') {
                        count++;
                    } else if (s.charAt(j) == '(') {
                        count--;
                    }
                    j--;
                }
                i = j + 1;
            }
        }

        //到这里没有进入下一层说明没有括号外的加减号，寻找'*'和'/'
        for (int i = n - 1; i >= 0; i--) {
            char cur = s.charAt(i);
            if (cur == '*' || cur == '/') {
                TreeNode root = new TreeNode(cur);
                root.right = expTree(s.substring(i+1));
                root.left = expTree(s.substring(0, i));
                return root;
            } else if (cur == ')') {
                int j = i - 1;
                int count = 1;
                while(j >= 0 && count > 0) {
                    if (s.charAt(j) == ')') {
                        count++;
                    } else if (s.charAt(j) == '(') {
                        count--;
                    }
                    j--;
                }
                i = j + 1;
            }
        }

        ////到这里没有进入下一层说明表达式本身被一对括号包裹，那么我们将这对括号脱去，处理里面的字符串
        if (s.charAt(0) == '(' && s.charAt(n-1) == ')') {
            return expTree(s.substring(1, n-1));
        }

        return null;

    }
}
