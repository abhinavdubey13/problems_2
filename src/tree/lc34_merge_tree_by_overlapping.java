package tree;

import models.TreeNode;


/**
 *
 * leetcode id : 617
 *
 *
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 *
 * You need to merge them into a new binary tree.
 * The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
 *
 * Otherwise, the NOT null node will be used as the node of new tree
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
 * similar to checking if 2 tree are identical
 *
 * ============
 * TC = O(n)
 * SC = O(n)
 *
 *
 */


public class lc34_merge_tree_by_overlapping {
}



class lc34_merge_tree_by_overlapping_soln {

    TreeNode function(TreeNode r1, TreeNode r2) {

        if (r1 == null) {
            return r2;
        }

        if (r2 == null) {
            return r1;
        }

        //make new node
        TreeNode root = new TreeNode(r1.val + r2.val);
        root.left = function(r1.left, r2.left);
        root.right = function(r1.right, r2.right);
        return root;
    }
}
