package tree;

import models.TreeNode;

import java.util.*;

/**
 *
 *
 * lc : 662
 *
 * Given a binary tree, write a function to get the maximum width of the given tree.
 * The maximum width of a tree is the maximum width among all levels.
 *
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level,
 * where the null nodes between the end-nodes are also counted into the length calculation.
 *
 */

/**
 *
 * ===========
 * approach :
 * ===========
 *
 *
 * use heap like indexing
 *
 * for each level , maintain start and end idx
 *
 * TC = O(n)
 * SC = O(ht)
 *
 */



public class lc27_max_width_of_tree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);

        System.out.println(new lc27_max_width_of_tree_soln().find(root));
    }
}


class lc27_max_width_of_tree_soln {

    Map<Integer, int[]> WIDTH;

    public int find(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return (root == null) ? 0 : 1;
        }

        WIDTH = new HashMap<>();
        helper(root, 1,1);

        int ans = 0;
        for (Map.Entry<Integer, int[]> e : WIDTH.entrySet()) {
            ans = Math.max(ans, e.getValue()[1] - e.getValue()[0] + 1);
        }
        return ans;
    }


    void helper(TreeNode curr, int level, int idx) {
        if (curr == null) {
            return;
        }

        if (this.WIDTH.containsKey(level)) {
            int[] arr = this.WIDTH.get(level);
            this.WIDTH.put(level, new int[]{arr[0], idx});
        } else {
            this.WIDTH.put(level, new int[]{idx, idx});
        }

        helper(curr.left, level + 1, 2 * idx);
        helper(curr.right, level + 1, 2 * idx + 1);
    }

}
