package tree;

import models.TreeNode;
/**
 *
 * leetcode id : 538
 *
 *
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree
 *
 * such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
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
 * =============
 *
 * 1. get inorder sequence
 * 2. convert the inorder seq to prefix array , but start from the end of the sequence
 * 3. set the prefix sum seq as the new inorder in the tree
 *
 * ===============
 * TC = O(n)
 * SC = O(n)
 *
 *
 *
 *
 * ============
 * approach : 2
 * =============
 *
 * Since this is a BST, we can do a reverse inorder traversal to traverse the nodes of the tree in descending order.
 *
 * In the process, we keep track of the running sum of all nodes which we have traversed thus far
 *
 * ===============
 * TC = O(n)
 * SC = O(n)
 *
 */


public class lc19_BST_to_greater_tree {
    public static void main(String[] args) {

        //tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);



    }
}


class lc19_BST_to_greater_tree_soln {

    int SUM;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }

        this.SUM = 0;
        this.helper(root);
        return root;
    }


    void helper(TreeNode curr) {
        if (curr == null) {
            return;
        }

        helper(curr.right);

        this.SUM += curr.val;
        curr.val = this.SUM;

        helper(curr.left);

    }
}
