package tree.done;

import models.TreeNode;

/**
 *
 * leetcode id : 530
 * 
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 *
 * Given a binary search tree with non-negative values,
 *
 * find the minimum absolute difference between values of any two nodes.
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
 * FACT : inorder traversal of BST gives sorted order
 *
 * in a sorted sequence , the minimum difference is between 2 consecutive nodes
 *
 * thus we maintain a prev node global variable
 *
 * ============
 * TC = O(n)
 * SC = O(ht)
 *
 *
 */

public class lc30_min_abs_diff_in_BST {
}


class lc30_min_abs_diff_in_BST_soln {

    int ANSWER;
    TreeNode PREVIOUS;

    int function_util(TreeNode root) {
        if (root == null) {
            return 0;
        }

        this.PREVIOUS = null;
        this.ANSWER = Integer.MAX_VALUE;
        helper(root);
        return this.ANSWER;
    }

    void helper(TreeNode curr) {

        if (curr == null) {
            return;
        }

        helper(curr.left);

        if (PREVIOUS == null) {
            PREVIOUS = curr;
        } else {
            this.ANSWER = Math.min(ANSWER, Math.abs(PREVIOUS.val - curr.val));
            PREVIOUS = curr;
        }

        helper(curr.right);
    }
}