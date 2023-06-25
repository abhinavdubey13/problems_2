package tree.done_lc;

import models.TreeNode;

/**
 *
 * leetcode id : 226
 *
 * https://leetcode.com/problems/invert-binary-tree/description/
 * 
 * Invert a binary tree.
 *
 *
 * ==========
 * example :
 * ==========
 *
 * i/p :
 * o/p :
 *
 */

/**
 * ============
 * approach : 1
 * ============
 *
 * 
 * start inverting from the last level , and move upwards
 *
 * post order traversal
 *
 *
 * ============
 * TC = O(n)
 * SC = O(ht)
 *
 *
 */

public class lc21_invert_tree {
}


class lc21_invert_tree_soln {

    public TreeNode invert(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }

        this.helper(root);
        return root;
    }

    private void helper(TreeNode curr) {
        if (curr == null) {
            return;
        }

        helper(curr.left);
        helper(curr.right);

        TreeNode temp = curr.left;
        curr.left = curr.right;
        curr.right = temp;
    }
}
