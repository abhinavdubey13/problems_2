package tree.a_done_classic;

/**
 * check if the given Binary Tree is SumTree .
 *
 * A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree.
 * An empty tree is SumTree and sum of an empty tree can be considered as 0.
 * A leaf node is also considered as SumTree.
 * 
 */

import models.TreeNode;

/**
 *
 * approach : recursively check if (sum of LST) + (sum of RST) = node-data
 *
 * the method here , returns the sum of all nodes , rooted at currentNode as Root
 *
 * TC - O(n)
 * SC - O(height)
 *
 */
public class p20_check_sum_tree {

    public static void main(String[] args) {

        //true
//        TreeNode root = new TreeNode(26);
//        root.left = new TreeNode(10);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(6);
//        root.right.right = new TreeNode(3);

        //false
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(15);


        System.out.println(new p20_check_sum_tree_soln().check(root));

    }
}


class p20_check_sum_tree_soln {

    boolean final_answer;

    boolean check(TreeNode root) {
        if (root == null) {
            return true;
        }
        this.final_answer = true;
        helper(root);
        return final_answer;
    }

    int helper(TreeNode curr) {
        if (curr == null) {
            return 0;
        }

        //leaf node
        if (curr.left == null && curr.right == null) {
            return curr.val;
        }

        //below is only for non-leaf(internal nodes)
        int l = helper(curr.left);
        int r = helper(curr.right);

        final_answer = (final_answer && curr.val == (l + r));
        return l + r + curr.val;
    }


}
