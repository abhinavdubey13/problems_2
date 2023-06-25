package tree.done_lc;

import models.TreeNode;

/**
 *
 * leetcode : 1038
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * 
 * 
 * leetcode id : 538
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 * 
 *
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
 *
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 *
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 *
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 *
 *
 */

/**
 *
 * reverse in-order traversal + using recursion
 * 
 * 
 * look at lc3_bst_to_greater_sum_tree_soln_2
 *
 */

public class lc3_bst_to_greater_sum_tree {
    public static void main(String[] args) {

        // TreeNode root = getTreee1();
        TreeNode root = getTreee2();
        root = new lc3_bst_to_greater_sum_tree_soln().bstToGst(root);
        root.print_in_order(root);
    }

    static TreeNode getTreee1() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        return root;
    }

    static TreeNode getTreee2() {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(50);
        root.left.left = new TreeNode(10);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(40);

        root.right = new TreeNode(200);
        root.right.right = new TreeNode(300);
        root.right.right.right = new TreeNode(400);
        return root;
    }
}

class lc3_bst_to_greater_sum_tree_soln {

    public TreeNode bstToGst(TreeNode root) {
        helper(root, 0);
        return root;
    }

    int helper(TreeNode curr, int addMe) {
        if (curr == null) {
            return 0;
        }

        int curr_val = curr.val;
        int sum_right = helper(curr.right, addMe);
        int sum_left = helper(curr.left, sum_right + curr_val + addMe);

        curr.val += (sum_right + addMe);
        return curr_val + sum_left + sum_right;
    }
}


class lc3_bst_to_greater_sum_tree_soln_2 {

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
