package tree.done_lc;

import models.TreeNode;


/**
 *
 * lc : 814
 * 
 * https://leetcode.com/problems/binary-tree-pruning/
 *
 * We are given the head node root of a binary tree,
 *
 * where  every node's value is either a 0 or a 1.
 *
 * Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 *
 *
 */


/**
 *
 * ===========
 * approach :
 * ===========
 *
 * using recursion
 *
 * remove all subtrees whose sum is zero
 *
 *
 * TC = O(n)
 * SC = O(ht)
 *
 */
public class lc33_pruning_tree {
}


class lc33_pruning_tree_soln {

    TreeNode find(TreeNode root) {
        int sum = helper(root);

        if (sum == 0) {
            return null;
        }
        return root;
    }

    static int helper(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int sum_left = helper(root.left);
        int sum_right = helper(root.right);

        if (sum_left == 0) {
            root.left = null;
        }

        if (sum_right == 0) {
            root.right = null;
        }

        return root.val + sum_left + sum_right;
    }
}