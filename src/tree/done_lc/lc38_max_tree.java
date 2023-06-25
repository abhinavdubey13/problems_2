package tree.done_lc;

import models.TreeNode;

/**
 *
 * leetcode id : 654
 *
 * You are given an integer array nums with no duplicates.
 *
 * A maximum binary tree can be built recursively from nums using the following algorithm:
 *
 * 1. Create a root node whose value is the maximum value in nums.
 *
 * 2. Recursively build the left subtree on the subarray prefix to the left of the maximum value.
 *
 * 3. Recursively build the right subtree on the subarray suffix to the right of the maximum value.
 *
 * Return the maximum binary tree built from nums
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
 * recursive
 *
 * maintain low and high at each function call , to be able to know the range in
 * the input array to search for Largest number
 *
 *
 *
 * ==============
 * TC = O(n)
 * SC = O(height)
 *
 *
 */

public class lc38_max_tree {
}

class lc38_max_tree_soln {

    TreeNode function_util(int[] arr) {
        return helper(arr, 0, arr.length - 1);
    }

    TreeNode helper(int[] arr, int low, int high) {
        int n = arr.length;
        if (low < 0 || high >= n) {
            return null;
        }

        TreeNode curr = null;

        if (low == high) {
            curr = new TreeNode(arr[low]);
            return curr;

        }

        int idx = find_max_idx(arr, low, high);
        curr = new TreeNode(arr[idx]);

        if (idx == low) {
            curr.right = helper(arr, low + 1, high);
        } else if (idx == high) {
            curr.left = helper(arr, low, high - 1);

        } else {
            curr.left = helper(arr, low, idx - 1);
            curr.right = helper(arr, idx + 1, high);
        }

        return curr;

    }

    int find_max_idx(int[] arr, int low, int high) {
        int answer = low;
        for (int i = low; i <= high; i++) {
            if (arr[answer] < arr[i]) {
                answer = i;
            }
        }
        return answer;
    }

}

class lc38_max_tree_rev1 {

    public TreeNode constructMaximumBinaryTree(int[] arr) {
        int len = arr.length;
        return helper(arr, len, 0, len - 1);
    }

    TreeNode helper(int[] arr, int len, int i, int j) {
        if (i < 0 || j >= len || i > j) {
            return null;
        }

        if (i == j) {
            return new TreeNode(arr[i]);
        }

        int mx_idx = max_val_idx(arr, len, i, j);
        if (mx_idx < 0 || mx_idx >= len) {
            return null;
        }

        TreeNode curr = new TreeNode(arr[mx_idx]);
        curr.left = helper(arr, len, i, mx_idx - 1);
        curr.right = helper(arr, len, mx_idx + 1, j);
        return curr;

    }

    int max_val_idx(int[] arr, int len, int i, int j) {
        if (i < 0 || j >= len || i > j) {
            return -1;
        }
        if (i == j) {
            return i;
        }
        int ans = i;
        for (int k = i; k <= j; k++) {
            if (arr[k] > arr[ans]) {
                ans = k;
            }
        }
        return ans;
    }
}