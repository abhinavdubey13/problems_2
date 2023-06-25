package tree.done;

import models.TreeNode;

import java.util.*;

/**
 *
 * leetcode id : 437
 * 
 * https://leetcode.com/problems/path-sum-iii/description/
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
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
 * So the idea is using HashMap to store prefix sum in the current root-to-leaf
 * path
 *
 * key : the prefix sum,
 * value : how many ways get to this prefix sum ,
 *
 * and whenever reach a node, we check if prefix sum - target exists in hashmap
 * or not,
 * if it does, we added up the ways of prefix sum - target into res.
 *
 * For instance : in one path we have 1,2,-1,-1,2,
 * then the prefix sum will be: 1, 3, 2, 1, 3,
 *
 * let's say we want to find target sum is 2, then we will have{2}, {1,2,-1},
 * {2,-1,-1,2} and {2} ways.
 *
 * ===============
 * TC = O(n)
 * SC = O(n)
 *
 *
 */

public class lc26_path_sum_3 {

    public static void main(String[] args) {
        TreeNode root = getTree2();
        int target =22;
        int ans = new lc26_path_sum_3_soln().find(root, target);
        System.out.println(ans);
    }

    static TreeNode getTree1() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);

        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        return root;
    }

    static TreeNode getTree2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        return root;
    }
}


class lc26_path_sum_3_soln {

    private Map<Integer, Integer> hmap;
    private int ANSWER;

    int find(TreeNode root, int target_sum) {
        hmap = new HashMap<>();
        this.ANSWER = 0;

        this.helper(root, target_sum, 0);
        return ANSWER;
    }

    private void helper(TreeNode curr, int target_sum, int path_sum) {
        if (curr == null) {
            return;
        }

        int sum_till_now = path_sum + curr.val;
        int sum_required = sum_till_now - target_sum;// ??

        if (hmap.containsKey(sum_required)) {
            this.ANSWER += hmap.get(sum_required);
        }

        this.hmap.put(sum_till_now, 1 + hmap.getOrDefault(sum_till_now, 0));
        helper(curr.left, target_sum, sum_till_now);
        helper(curr.right, target_sum, sum_till_now);
        this.hmap.put(sum_till_now, hmap.get(sum_till_now) - 1);

    }
}
