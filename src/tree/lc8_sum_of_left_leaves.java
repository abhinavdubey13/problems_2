package tree;

import models.TreeNode;

/**
 *
 * leetcode id : 404
 *
 * Find the sum of all left leaves in a given binary tree.
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
 * maintain direction as a parameter in function call
 *
 * ============
 * TC = O(n)
 * SC = O(ht)
 *
 *
 */

public class lc8_sum_of_left_leaves {
    public static void main(String[] args) {

        //tree
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);

        System.out.println(new lc8_sum_of_left_leaves_soln().find(root));

    }
}


class lc8_sum_of_left_leaves_soln {

    int ANSWER;

    int find(TreeNode root) {
        if (root == null || root.isLeaf()) {
            return 0;
        }

        this.ANSWER = 0;
        helper(root.left, 'L');
        helper(root.right, 'R');

        return this.ANSWER;
    }

    private void helper(TreeNode curr, char direction) {
        if (curr == null) {
            return;
        }

        if (curr.isLeaf() && direction == 'L') {
            this.ANSWER += curr.val;
        }

        helper(curr.left, 'L');
        helper(curr.right, 'R');

    }
}