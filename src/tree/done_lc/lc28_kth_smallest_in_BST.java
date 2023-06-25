package tree.done;

import models.TreeNode;

import java.util.*;


/**
 * leetcode id : 230
 *
 *
 * Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree
 *
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 *
 * 
 *
 */


/**
 *
 * iterative in-order
 *
 */

public class lc28_kth_smallest_in_BST {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(40);


        int k = 4;
        int ans = new lc28_kth_smallest_in_BST_soln().find(root, k);
        System.out.println(ans);

    }

}


class lc28_kth_smallest_in_BST_soln {


    int find(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode itr = root;

        int ans = -1;

        while (itr != null || stk.size() > 0) {
            while (itr != null) {
                stk.push(itr);
                itr = itr.left;
            }

            itr = stk.pop();

            //process begin
            k--;
            if (k == 0) {
                ans = itr.val;
            }
            //process ends

            itr = itr.right;
        }


        return ans;
    }

}
