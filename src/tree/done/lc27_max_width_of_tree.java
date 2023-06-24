package tree.done;

import models.TreeNode;

import java.util.*;

/**
 *
 *
 * lc : 662
 *
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
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
        root.left.left.left = new TreeNode(6);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(7);

        // System.out.println(new lc27_max_width_of_tree_soln().find(root));
        System.out.println(new lc27_max_width_of_tree_soln_rev1().find(root));

    }
}

class lc27_max_width_of_tree_soln_rev1 {
    class HmapObj {
        int start_idx;
        int end_idx;
        int level;

        HmapObj(int level, int start_idx, int end_idx) {
            this.level = level;
            this.start_idx = start_idx;
            this.end_idx = end_idx;
        }
    }

    Map<Integer, HmapObj> hmap;

    public int find(TreeNode root) {
        hmap = new HashMap<>();
        int max_width = 0;
        helper(root, 1, 1);
        for (Map.Entry<Integer, HmapObj> entry : hmap.entrySet()) {
            HmapObj obj = entry.getValue();
            max_width = Math.max(max_width, obj.end_idx - obj.start_idx);
        }
        return max_width + 1;
    }

    void helper(TreeNode curr, int idx, int level) {
        if (curr == null) {
            return;
        }

        if (hmap.containsKey(level)) {
            HmapObj obj = hmap.get(level);
            obj.end_idx = Math.max(obj.end_idx, idx);
        } else {
            hmap.put(level, new HmapObj(level, idx, idx));
        }

        helper(curr.left, 2 * idx, level + 1);
        helper(curr.right, 2 * idx + 1, level + 1);

    }
}

class lc27_max_width_of_tree_soln {

    Map<Integer, int[]> WIDTH;

    public int find(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return (root == null) ? 0 : 1;
        }

        WIDTH = new HashMap<>();
        helper(root, 1, 1);

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
            this.WIDTH.put(level, new int[] { arr[0], idx });
        } else {
            this.WIDTH.put(level, new int[] { idx, idx });
        }

        helper(curr.left, level + 1, 2 * idx);
        helper(curr.right, level + 1, 2 * idx + 1);
    }

}
