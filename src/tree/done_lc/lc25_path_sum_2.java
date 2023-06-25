package tree.done_lc;

import models.TreeNode;

import java.util.*;

/**
 * leetcode id : 113
 * 
 * https://leetcode.com/problems/path-sum-ii/
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * ==========
 * example :
 * ==========
 *
 * i/p :
 * o/p :
 */

/**
 * ============
 * approach : 1
 * =============
 *
 * simple , maintian current path in global array
 *
 * andd current root to leaf path if sum matches
 *
 * ===============
 * TC = O(n)
 * SC = O(n)
 * 
 */

public class lc25_path_sum_2 {

    public static void main(String[] args) {

        // tree
        TreeNode root;
        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int target_sum = 22;

        List<List<Integer>> answer = new lc25_path_sum_2_soln().find(root, target_sum);

        // debug here to check the answer list
        for (List<Integer> l : answer) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}

class lc25_path_sum_2_soln {

    List<List<Integer>> ANSWER;
    List<Integer> CURR_PATH;

    List<List<Integer>> find(TreeNode root, int target_sum) {
        this.ANSWER = new LinkedList<>();
        this.CURR_PATH = new LinkedList<>();
        helper(root, target_sum, 0);
        return this.ANSWER;
    }

    private void helper(TreeNode curr, int target_sum, int sum_till_now) {
        if (curr == null) {
            return;
        }

        //add curr node to path
        this.CURR_PATH.add(curr.val);
        int sum_from_root_till_curr = sum_till_now + curr.val;



        // if leaf node , check path sum & update final answer if sum-match
        // if not leaf , continue DFS
        if (curr.left == null && curr.right == null) {
            this.addListToFinalAns(this.CURR_PATH, target_sum, sum_from_root_till_curr);
        } else {
            helper(curr.left, target_sum, sum_from_root_till_curr);
            helper(curr.right, target_sum, sum_from_root_till_curr);
        }

        if (this.CURR_PATH.size() > 0) {
            this.CURR_PATH.remove(this.CURR_PATH.size() - 1);
        }
    }

    private void addListToFinalAns(List<Integer> validList, int target_sum, int sum_root_to_leaf) {
        if (validList == null || validList.size() == 0 || target_sum != sum_root_to_leaf) {
            return;
        }

        List<Integer> temp = new LinkedList<>();
        for (Integer i : validList) {
            temp.add(i);
        }
        this.ANSWER.add(temp);
    }

}
