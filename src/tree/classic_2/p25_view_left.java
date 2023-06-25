package tree.classic_2;

import models.TreeNode;

import java.util.*;


/**
 *
 * given a binary tree , print its left view
 *
 *
 *
 */

/**
 *
 * nodes in left view are 1st node of each level in level order traversal
 *
 * thus we use level order traversal , using QUEUE , along with node data , we also note the level of each node in queue
 * we print only if the level is more than previous_max_level
 *
 * =================================
 * TC = O(n)
 * SC = O(maximum nodes at a level)
 *
 *
 *
 *
 * approach-2 : use DFS for the same , space will be optimized
 *
 *
 *
 */
public class p25_view_left {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer>ans = new p25_view_left_soln().find(root);
        for(Integer i : ans){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}


class p25_view_left_soln {
    private int MAX_LEVEL;
    List<Integer> left_view;

    List<Integer> find(TreeNode root) {
        this.left_view = new LinkedList<>();
        this.MAX_LEVEL = -1;
        helper(root, 0);
        return this.left_view;
    }

    private void helper(TreeNode curr, int curr_level) {
        if (curr == null) {
            return;
        }
        if (curr_level > this.MAX_LEVEL) {
            this.left_view.add(curr.val);
            this.MAX_LEVEL = curr_level;
        }

        helper(curr.left, curr_level + 1);
        helper(curr.right, curr_level + 1);
    }

}
