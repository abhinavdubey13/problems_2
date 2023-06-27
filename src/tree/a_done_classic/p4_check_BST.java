package tree.a_done_classic;

import models.TreeNode;

import java.util.Stack;

/**
 *
 * lc : 98
 * 
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * checking if a given tree is BST
 *
 */

/**
 *
 * using iterative in-order traversal
 *
 * TC = O(n)
 * SC = O(height)
 *
 */

public class p4_check_BST {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6); // add this => BST
        // root.right.right = new TreeNode(1); //add this => not a BST

        System.out.println(p4_check_BST_soln.checkBST(root));
    }
}

class p4_check_BST_soln {

    static boolean checkBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        Stack<TreeNode> stk = new Stack<>();
        TreeNode ptr = root;
        Integer previous_val = null;

        while (ptr != null || stk.size() > 0) {

            while (ptr != null) {
                stk.push(ptr);
                ptr = ptr.left;
            }

            if (stk.size() > 0) {
                ptr = stk.pop();

                // checking condition
                if (previous_val != null && previous_val > ptr.val) {
                    return false;
                }
                previous_val = ptr.val;// updating prev_val

                // moving on
                ptr = ptr.right;

            }
        }

        return true;

    }
}

class p4_check_BST_soln_using_recursion {

    boolean ans;
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        ans = true;
        prev = null;
        helper(root);
        return ans;

    }

    void helper(TreeNode curr) {
        if (curr == null || ans == false) {
            return;
        }

        helper(curr.left);
        if (prev != null && prev.val >= curr.val) {
            ans = false;
        }
        prev = curr;
        helper(curr.right);
    }
}
