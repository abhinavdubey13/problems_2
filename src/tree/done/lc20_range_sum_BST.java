package tree.done;


/**
 * leetcode id : 938
 *
 * https://leetcode.com/problems/range-sum-of-bst/
 * 
 * Given the root node of a binary search tree,
 *
 * return the sum of values of all nodes with a value in the range [low, high].
 *
 *
 * ==========
 * example :
 * ==========
 *
 * i/p :
 * o/p :
 */

import models.TreeNode;

/**
 * ============
 * approach : 1
 * ============
 * normal : traverse all nodes
 *
 * ============
 * TC = O(n)
 * SC = O(ht)
 *
 *
 *
 * ============
 * approach : 2
 * ============
 *
 * use given fact that given tree is BST
 *
 * so depending on current node value we can go left or right or both
 *
 * ============
 * TC = O(ht)
 * SC = O(ht)
 */

public class lc20_range_sum_BST {
}


class lc20_range_sum_BST_soln {

    private int ANSWER;

    int find(TreeNode root, int low, int high) {
        this.ANSWER = 0;
        this.helper(root, low, high);
        return this.ANSWER;
    }

    private void helper(TreeNode curr, int low, int high) {
        if (curr == null) {
            return;
        }

        if (curr.val < low) {

            //only go right
            helper(curr.right, low, high);
        } else if (curr.val > high) {

            //only go left
            helper(curr.left, low, high);
        } else {

            //curr in range , go in both directions
            this.ANSWER += curr.val;
            helper(curr.left, low, high);
            helper(curr.right, low, high);
        }


    }
}
