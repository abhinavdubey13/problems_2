package tree.classic_2;

import models.TreeNode;

/**
 *
 * Given a binary tree and an array, the task is
 * to find if the given array sequence is present as a root to leaf path in given tree.
 *
 *
 */


/**
 *
 * approach : recursively check if the index in the input parameter matches the rootNode
 *
 * TC - O(n)
 * SC - O(height)
 *
 */


public class p24_check_path_exist {

    public static void main(String[] args) {

        //true
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        //int[] seq = { 1, 2, 5 }; //true
         int[] seq = { 1, 2, 7 }; //false


        System.out.println(new p24_check_path_exist_soln().check(root, seq));

    }
}

class p24_check_path_exist_soln {


    boolean[] vis;

    boolean check(TreeNode root, int[] arr) {
        if (root == null && arr.length == 0) {
            return true;
        }

        if (root == null || arr.length == 0) {
            return false;
        }

        //set everythng to false
        vis = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            vis[i] = false;
        }

        //call helper , then everythng should be true for final answer to be true
        helper(root, arr, 0);
        for (int i = 0; i < arr.length; i++) {
            if (!vis[i]) {
                return false;
            }
        }

        return true;
    }


    void helper(TreeNode curr, int[] arr, int idx_to_check) {
        if (curr == null) {
            return;
        }

        if (idx_to_check < arr.length && curr.val == arr[idx_to_check]) {

            //for last idx , node should be leaf
            if (idx_to_check == arr.length - 1) {
                vis[idx_to_check] = (curr.left == null && curr.right == null);
            } else {
                vis[idx_to_check] = true;
            }
        }

        helper(curr.left, arr, idx_to_check + 1);
        helper(curr.right, arr, idx_to_check + 1);
    }


}
