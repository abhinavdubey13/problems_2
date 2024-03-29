package tree.a_done_classic;

import models.TreeNode;

import java.util.*;

/**
 *
 * lc:199
 *
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * 
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 *
 */


/**
 *
 * 
 * goto right first , instead of left
 * similar to left view , DFS
 *
 */
public class p26_view_right {
}


class p26_view_right_soln {
    private int MAX_LEVEL;
    List<Integer> right_view;

    List<Integer> find(TreeNode root) {
        this.right_view = new LinkedList<>();
        this.MAX_LEVEL = -1;
        helper(root, 0);
        return this.right_view;
    }

    private void helper(TreeNode curr, int curr_level) {
        if (curr == null) {
            return;
        }
        if (curr_level > this.MAX_LEVEL) {
            this.right_view.add(curr.val);
            this.MAX_LEVEL = curr_level;
        }

        helper(curr.right, curr_level + 1);
        helper(curr.left, curr_level + 1);
    }

}
