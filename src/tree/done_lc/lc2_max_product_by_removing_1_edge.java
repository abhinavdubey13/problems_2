package tree.done_lc;

import models.TreeNode;

/**
 * leetcode id : 1339
 * 
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 *
 * Given a binary tree root ,  Split the binary personal.tree into two subtrees by removing 1 edge
 *
 * such that the product of the sums of the subtrees are maximized.
 * 
 * Return the maximum product of the sums of the two subtrees
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 */

/**
 *
 * find sum of all nodes
 *
 * at each node find max of
 * (TOTAL_SUM-lst_sum)*lst_sum , (TOTAL_SUM-rst_sum)*rst_sum
 *
 * like this
 *
 * TC=SC=O(n)
 *
 */

public class lc2_max_product_by_removing_1_edge {

    public static void main(String[] args) {

    }
}

class lc2_max_product_by_removing_1_edge_soln {

    int TREE_SUM;
    int MAX_PROD;
    int MOD = 1000000007;

    public int maxProduct(TreeNode root) {
        TREE_SUM = 0;
        MAX_PROD = Integer.MIN_VALUE;
        set_tree_sum(root);
        set_max_prod(root);
        return MAX_PROD;
    }

    int set_max_prod(TreeNode curr) {
        if (curr == null) {
            return 0;
        }

        int sum_lst = set_max_prod(curr.left);
        int sum_rst = set_max_prod(curr.right);

        int prod_1 = ((TREE_SUM - sum_lst) * sum_lst) % MOD;
        int prod_2 = ((TREE_SUM - sum_rst) * sum_rst) % MOD;
        MAX_PROD = Math.max(MAX_PROD, Math.max(prod_1, prod_2));

        return curr.val + sum_rst + sum_lst;
    }

    void set_tree_sum(TreeNode curr) {
        if (curr != null) {
            TREE_SUM += curr.val;
            set_tree_sum(curr.left);
            set_tree_sum(curr.right);
        }

    }

}

class lc2_max_product_by_removing_1_edge_rev_1 {

    static int answer = 0;
    static int MOD = 1000000007;

    public int maxProduct(TreeNode root) {
        int tree_sum = find_tree_sum(root);
        find_max_split_sum(root, tree_sum);
        return answer;
    }

    static int find_max_split_sum(TreeNode root, int tree_sum) {
        if (root == null) {
            return 0;
        }

        int left_sum = find_max_split_sum(root.left, tree_sum);
        int right_sum = find_max_split_sum(root.left, tree_sum);

        int product_on_removing_left_edge = ((left_sum * (tree_sum - left_sum)) % MOD);
        int product_on_removing_right_edge = ((right_sum * (tree_sum - right_sum)) % MOD);
        answer = Math.max(answer, Math.max(product_on_removing_left_edge, product_on_removing_right_edge));

        return root.val + right_sum + left_sum;
    }

    static int find_tree_sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.isLeaf()) {
            return root.val;
        }

        int left_sum = find_tree_sum(root.left);
        int right_sum = find_tree_sum(root.right);
        return left_sum + right_sum + root.val;
    }

}
