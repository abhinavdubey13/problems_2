package tree.classic_2;

import models.TreeNode;

/**
 *
 * lc : 236
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as
 * the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 */

/**
 *
 * using recursion
 *
 *  TC = O(n)
 *  SC = O(n)
 *
 */

public class p5_LCA {
}


class p5_LCA_soln {

    TreeNode get_lca(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null || n1 == null || n2 == null) {
            return null;
        }

        return helper(root,n1,n2);
    }


    TreeNode helper(TreeNode curr, TreeNode n1, TreeNode n2) {

        if (curr == null || curr == n1 || curr == n2) {
            return curr;
        }

        TreeNode l = helper(curr.left, n1, n2);
        TreeNode r = helper(curr.right, n1, n2);

        if (l != null && r != null) {
            return curr;
        } else if (l != null) {
            return l;
        } else if (r != null) {
            return r;
        } else {
            return null;
        }

    }
}
