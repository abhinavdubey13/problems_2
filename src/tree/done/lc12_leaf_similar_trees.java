package tree.done;

import models.TreeNode;

/**
 *
 * leetcode id : 872
 * 
 * https://leetcode.com/problems/leaf-similar-trees/
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
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
 * ============
 *
 * convert leaf sequence to string using pre-order-traversal
 *
 * then compare 2 strings
 *
 * ============
 * TC = O(n)
 * SC = O(n)
 *
 *
 */

public class lc12_leaf_similar_trees {
}

class lc12_leaf_similar_trees_soln {

    static boolean function(TreeNode r1, TreeNode r2) {

        if (r1 == null && r2 == null) {
            return true;
        }

        if (r1 == null || r2 == null) {
            return false;
        }

        StringBuilder leaf_seq_1 = new StringBuilder();
        StringBuilder leaf_seq_2 = new StringBuilder();
        dfs(r1, leaf_seq_1);
        dfs(r2, leaf_seq_2);

        // as string buffers equals is not over-ridden
        return leaf_seq_1.toString().equals(leaf_seq_2.toString());
    }

    static void dfs(TreeNode curr, StringBuilder leaf_seq) {
        if (curr == null) {
            return;
        }

        if (curr.isLeaf()) {
            leaf_seq.append(String.valueOf(curr.val));
        }

        dfs(curr.left, leaf_seq);
        dfs(curr.right, leaf_seq);
    }
}
