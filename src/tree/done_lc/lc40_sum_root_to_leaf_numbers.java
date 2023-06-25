package tree.done_lc;

import java.util.*;
import models.TreeNode;

/**
 *
 * lc : 129
 * 
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * 
 * Given a binary tree containing digits from 0-9 only, 
 * 
 * each root-to-leaf path could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * 
 * ================================
 * example
 * 
 *          1
 *         / \
 *        4   5
 * 
 * answer  = 14 + 15 = 29
 *   
 */

/**
 * 
 * ===========
 * approach :
 * ===========
 * 
 * 
 * recursion top-down type
 * 
 * as in prev qstn
 *
 * TC = O(n)
 * SC = O(ht)
 *
 */

class lc40_sum_root_to_leaf_numbers {

    static int RESULT = 0;

    public static void main(String[] args) {

        TreeNode root;

        // tree-1 , expected = 1026
        root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);

        int answer = function_util(root);
        System.out.println(answer);

    }

    static int function_util(TreeNode root) {
        RESULT = 0;
        function(root, 0);
        return RESULT;

    }

    static void function(TreeNode root, int path_number) {
        if (root == null) {
            return;
        }

        int num_here = path_number * 10 + root.val;
        if (root.left == null && root.right == null) {
            RESULT += num_here;
        }

        function(root.left, num_here);
        function(root.right, num_here);
    }

}