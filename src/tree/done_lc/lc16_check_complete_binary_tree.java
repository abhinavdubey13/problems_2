package tree.done;

import models.TreeNode;

import java.util.*;


/**
 * lc : 958
 *
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 * 
 * Given a binary tree, determine if it is a complete binary tree.
 * Definition of a complete binary tree from Wikipedia:
 *
 * In a complete binary tree every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible.
 *
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *
 */


/**
 *
 * check 2 things
 *
 * 1. once a non-full(atleast 1 child is null) nodes is seen , all following nodes must be leaf node
 * 2. if left is null , right should be null
 *
 *
 * condition-2 will handle for the below type of cases :
 *
 *     1
 *   /   \
 *  2     3
 *   \
 *    4
 *
 */

public class lc16_check_complete_binary_tree {

    public static void main(String[] args) {

        //expected false
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);

        boolean ans = new lc16_check_complete_binary_tree_soln().find(root);
        System.out.println(ans);
    }
}


class lc16_check_complete_binary_tree_soln {


    public boolean find(TreeNode root) {

        if (root == null) {
            return true;
        }

        boolean non_full_node_seen = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (q.size() > 0) {

            TreeNode popped = q.poll();

            //************ processing-start ****************

            //all nodes must have either 
            // - both children , or 
            // - left child , or
            // - no child
            // ie. having only right child is NOT allowed
            if (popped.left == null && popped.right != null) {
                return false;
            }

            // once a non-full is seen , all next must be leaf nodes
            if (non_full_node_seen && !(popped.left == null && popped.right == null)) {
                return false;
            }

            non_full_node_seen = (non_full_node_seen || popped.left == null || popped.right == null);
            //************ processing-end ****************


            //moving forward in level-order-traversal
            if (popped.left != null) {
                q.offer(popped.left);
            }

            if (popped.right != null) {
                q.offer(popped.right);
            }
        }

        return true;
    }


}
