package tree.done;

import models.TreeNode;

import java.util.*;

/**
 *
 * lc: 1609
 *
 * The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.

 * A binary tree is named Even-Odd if it meets the following conditions:
 *
 * condition-1 : For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
 * condition-2 : For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
 *
 *
 * Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false
 *
 */

/**
 *
 * =====================
 * approach : iterative
 * ======================
 *
 *
 * do a BFS , and maintain another list of key-value pair
 * this list has nodes in BFS order
 *
 *
 * compare list depending on even-odd level
 *
 * for even level , sub-array of that level must be incremental
 * for odd level , sub-array of that level must be decremental
 *
 *
 * TC = O(n)
 * SC = O(1)
 *
 *
 * ======================
 * approach : recursive
 * ======================
 *
 * we maintain a hashmap , key=level , value=the last value encountered at that
 * level
 *
 * when we enter the helper method , we return FALSE when any 1 of below satisy
 * 1. odd value at odd level
 * 2. even value at even level
 * 3. at even-level we get a value less-than or equal to last value at that
 * level (we must have increased values in even-levels)
 * 4. at odd-level we get a value more-than or equal to last value at that level
 * (we must have decreased values in odd-levels)
 *
 * if none of the above satify , we reset hashmap
 * and return TRUE if node == null
 *
 *
 * TC = O(n)
 * SC = O(height)
 *
 */

public class lc13_even_odd_tree {

    public static void main(String[] args) {

        // tree-1 : falses
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(10);
        // root.left.left = new TreeNode(3);
        // root.left.left.left = new TreeNode(12);
        // root.left.left.right = new TreeNode(8);
        // root.right = new TreeNode(4);
        // root.right.left = new TreeNode(7);
        // root.right.left.left = new TreeNode(6);
        // root.right.right = new TreeNode(9);
        // root.right.right.right = new TreeNode(21);

        // tree-2
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(7);

        // lc13_even_odd_tree_soln s = new lc13_even_odd_tree_soln();
        lc13_even_odd_tree_soln_rev1 s = new lc13_even_odd_tree_soln_rev1();

        boolean result = s.find(root);

        // Iterative iterative_approach = new Iterative();
        // boolean result = iterative_approach.function(root);

        System.out.println(result);
    }
}

class lc13_even_odd_tree_soln {

    private boolean ANSWER;
    private Map<Integer, Integer> hmap;

    boolean find(TreeNode root) {
        this.ANSWER = true;
        this.hmap = new HashMap<>();
        this.helper(root, 0);
        return this.ANSWER;
    }

    private void helper(TreeNode curr, int level) {
        if (curr == null || ANSWER == false) {
            return;
        }

        // if level is odd , value should be even (vice-versa)
        ANSWER = ANSWER && (level % 2 != curr.val % 2);

        Integer prev_val = hmap.get(level);
        if (prev_val != null) {
            // even level : strictly incr from L to R
            // odd-level : strictly decr from L to R
            if (level % 2 == 0) {
                ANSWER = ANSWER && (prev_val < curr.val);
            } else {
                ANSWER = ANSWER && (prev_val > curr.val);
            }

        }

        hmap.put(level, curr.val);// update value at level
        helper(curr.left, level + 1);
        helper(curr.right, level + 1);

    }
}

class lc13_even_odd_tree_soln_rev1 {

    Map<Integer, Integer> hmap;
    boolean answer;

    public boolean find(TreeNode root) {
        hmap = new HashMap<>();
        this.answer = true;
        helper(root, 0);
        return answer;
    }

    private void helper(TreeNode root, int level) {
        if (root == null || this.answer == false) {
            return;
        }

        boolean is_even = level % 2 == 0;
        Integer old_val_at_this_level = this.hmap.getOrDefault(level, null);
        int curr_val = root.val;

        boolean is_even_level_criteria_violated = (old_val_at_this_level != null && curr_val <= old_val_at_this_level)
                || curr_val % 2 == 0;
        boolean is_odd_level_criteria_violated = (old_val_at_this_level != null && curr_val >= old_val_at_this_level)
                || curr_val % 2 == 1;

        if (is_even && is_even_level_criteria_violated || !is_even && is_odd_level_criteria_violated) {
            answer = false;
            return;
        }

        hmap.put(level, root.val);
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}