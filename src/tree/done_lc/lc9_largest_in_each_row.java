package tree.done;

import models.TreeNode;

import java.util.*;

/**
 *
 * leetcode id : 515
 *
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 *
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
 * using recursion
 *
 * ==============
 * TC = O(n)
 * SC = O(n)
 *
 *
 */

public class lc9_largest_in_each_row {
    public static void main(String[] args) {

        // tree
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);

        List<Integer> answer = new lc9_largest_in_each_row_soln().find(root);
        // List<Integer> answer = new lc9_largest_in_each_row_rev1().find(root);

        for (Integer i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}

class lc9_largest_in_each_row_soln {

    List<Integer> ANSWER;

    List<Integer> find(TreeNode root) {

        ANSWER = new LinkedList<>();
        this.helper(root, 0);
        return this.ANSWER;
    }

    private void helper(TreeNode curr, int level) {
        if (curr == null) {
            return;
        }

        if (this.ANSWER.size() <= level) {
            this.ANSWER.add(curr.val);
        } else {
            boolean isCurrLarger = this.ANSWER.get(level) < curr.val;
            if (isCurrLarger) {
                this.ANSWER.remove(level);
                this.ANSWER.add(level, curr.val);
            }
        }

        helper(curr.left, level + 1);
        helper(curr.right, level + 1);
    }
}