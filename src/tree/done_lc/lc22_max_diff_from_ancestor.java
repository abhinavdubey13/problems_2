package tree.done_lc;

import models.TreeNode;


/**
 *
 * leetcode id : 1026
 *
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 *
 * Given the root of a binary tree,
 *
 * find the maximum value V for which there exist different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.
 *
 * A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.
 *
 *
 *
 */

/**
 *
 *
 * ============
 * approach : 1
 * ============
 *
 *
 *
 * DFS
 *
 *
 *
 *
 *
 */

public class lc22_max_diff_from_ancestor {
}


class lc22_max_diff_from_ancestor_soln {

    private int ANSWER;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }

        this.helper(root, root.val, root.val);
        return this.ANSWER;
    }


    void helper(TreeNode curr, int min_till_now, int max_till_now) {
        if (curr == null) {
            return;
        }


        //find max diff with ancestors
        this.ANSWER = Math.max(this.ANSWER,
                Math.max(
                        Math.abs(min_till_now - curr.val),
                        Math.abs(max_till_now - curr.val)
                )
        );


        //dfs to left and right child
        helper(curr.left, Math.min(min_till_now, curr.val),
                Math.max(max_till_now, curr.val));

        helper(curr.right, Math.min(min_till_now, curr.val),
                Math.max(max_till_now, curr.val));
    }
}
