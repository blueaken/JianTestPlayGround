package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.lowestcommonancestor2;

import java.util.HashSet;

/**
 * Author: blueaken
 * Date: 4/21/16 11:51 AM
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
//    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
//                                                 ParentTreeNode A,
//                                                 ParentTreeNode B) {
//        // Write your code here
//        if (root == null) {
//            return null;
//        }
//
//        Set<ParentTreeNode> visited = new HashSet<>();
//        while (A != null) {
//            visited.add(A);
//            A = A.parent;
//        }
//        while (B != null) {
//            if (visited.contains(B)){
//                return B;
//            }
//            B = B.parent;
//        }
//
//        return null;
//    }
}
