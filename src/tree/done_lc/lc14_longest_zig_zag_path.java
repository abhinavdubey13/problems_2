package tree.done;

import models.TreeNode;

import java.util.Map;

/**
 *
 * lc : 1372
 *
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
 * 
 * Given a binary tree root, a ZigZag path for a binary tree is defined as follow:
 *
 *
 * Choose any node in the binary tree and a direction (right or left).
 * If the current direction is right then move to the right child of the current node otherwise move to the left child.
 * Change the direction from right to left or right to left.
 * Repeat the second and third step until you can't move in the tree.
 * Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
 *
 *
 * Return the longest ZigZag path contained in that tree
 *
 */

/**
 *
 * ===========
 * approach :
 * ===========
 * recursive
 *
 * pass currentdirection info , while recursion
 *
 * if current == left
 * return 1+right
 *
 * else
 * return 1+left
 *
 *
 * TC = O(n)
 * SC = O(height)
 *
 */

public class lc14_longest_zig_zag_path {

    public static void main(String[] args) {

        TreeNode root;

        // tree-2 : expected=3
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.left.right = new TreeNode(6);
        root.right.right.left.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        // int result = new lc14_longest_zig_zag_path_soln().find(root);
        int result = new lc14_longest_zig_zag_path_rev1().find(root);
        System.out.println(result);
    }
}

class lc14_longest_zig_zag_path_soln {

    Integer ANSWER;

    int find(TreeNode root) {
        if (root == null) {
            return 0;
        }

        this.ANSWER = 0;
        this.helper(root, 0, "L");
        this.helper(root, 0, "R");
        return this.ANSWER;
    }

    void helper(TreeNode curr, int curr_zig_zag_len, String direction) {
        if (curr == null) {
            return;
        }

        this.ANSWER = Math.max(this.ANSWER, curr_zig_zag_len);

        if (direction == "L") {
            helper(curr.left, 0, "L");
            helper(curr.left, curr_zig_zag_len + 1, "R");
        } else if (direction == "R") {
            helper(curr.right, curr_zig_zag_len + 1, "L");
            helper(curr.right, 0, "R");
        }
    }

}

class lc14_longest_zig_zag_path_rev1 {

    int answer;

    public int find(TreeNode root) {
        answer = 0;
        helper(root.left, 1, 0);
        helper(root.right, 1, 1);
        return answer;

    }

    void helper(TreeNode root, int number_of_zig_zag_edges_till_now, int direction) {
        if (root == null) {
            return;
        }

        this.answer = Math.max(this.answer, number_of_zig_zag_edges_till_now);

        if (direction == 0) {
            helper(root.left, 1, 0);
            helper(root.right, number_of_zig_zag_edges_till_now + 1, 1);
        } else {
            helper(root.left, number_of_zig_zag_edges_till_now + 1, 0);
            helper(root.right, 1, 1);
        }
    }
}