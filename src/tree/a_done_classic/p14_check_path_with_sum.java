package tree.a_done_classic;

import models.TreeNode;

/**
 * given a binary tree , check if there is a path from ROOT to leaf with a given sum
 */

/**
 * recursively check LST and RST with (sumLeft = SUM - node.data )
 *
 *
 */


public class p14_check_path_with_sum {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int sumRequired = 8;

        boolean answer = p14_check_path_with_sum_soln.check(root, sumRequired);
        System.out.println(answer);

    }
}


class p14_check_path_with_sum_soln {

    static boolean check(TreeNode root, int sum) {
        if (root == null) {
            return sum == 0;
        }

        boolean l = check(root.left, sum - root.val);
        boolean r = check(root.right, sum - root.val);

        return l || r;
    }
}
