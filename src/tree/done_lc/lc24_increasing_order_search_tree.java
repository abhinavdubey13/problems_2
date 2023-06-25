package tree.done_lc;


/**
 *
 * leetcode id : 897
 * 
 * https://leetcode.com/problems/increasing-order-search-tree/
 *
 * Given the root of a binary search tree,
 *
 * rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree,
 *
 * and every node has no left child and only one right child.
 *
 * ==========
 * example :
 * ==========
 *
 * i/p :
 * o/p :
 *
 */

import models.TreeNode;

/**
 * ============
 * approach : 1
 * ============
 *
 * use inorder traversal
 *
 * maintain the new-root and rightmost of new-root as global variales
 *
 * ============
 * TC = O(n)
 * SC = O(n)
 *
 *
 */



public class lc24_increasing_order_search_tree {
}


class lc24_increasing_order_search_tree_soln {

    TreeNode NEW_ROOT;
    TreeNode ITERATOR;

    TreeNode find(TreeNode root) {

        if (root == null || root.left==null && root.right==null) {
            return root;
        }

        NEW_ROOT = new TreeNode(-1); //adding dummy node to init the variables
        ITERATOR = NEW_ROOT;
        helper(root);
        return NEW_ROOT.right;
    }

    void helper(TreeNode curr) {
        if (curr == null) {
            return;
        }

        //save pointers
        TreeNode lst = curr.left;
        TreeNode rst = curr.right;

        helper(lst);

        //swap-start
        curr.left = null;
        curr.right = null;
        ITERATOR.right = curr;
        ITERATOR = ITERATOR.right;
        //swap-ends

        helper(rst);
    }

}
