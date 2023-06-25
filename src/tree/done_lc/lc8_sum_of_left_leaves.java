package tree.done_lc;

import models.TreeNode;

/**
 *
 * leetcode id : 404
 *
 * https://leetcode.com/problems/sum-of-left-leaves/
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


class lc8_sum_of_left_leaves_soln_rev1 {

    int answer;
    public int sumOfLeftLeaves(TreeNode root) {
        answer=0;
        helper(root, false);
        return answer;
    }

    void helper(TreeNode root , boolean isLeft){
        if(root==null){
            return;
        }

        if(root.left==null && root.right==null && isLeft){
            answer += root.val;
        }

        helper(root.left, true);
        helper(root.right, false);

    }
}