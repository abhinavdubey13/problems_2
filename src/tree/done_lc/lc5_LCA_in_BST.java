package tree.done_lc;

import models.TreeNode;

/**
 * leetcode id : 235
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST
 *
 */

/**
 *
 *
 * ============
 * approach : 1
 * ============
 *
 *
 * LCA + BST property
 *
 *
 * if p and q are smaller than curr , then curr cannot be LCA , LCA must be LHS
 *
 * if p and q are greater than curr , then curr cannot be LCA , LCA must be RHS
 *
 *
 * else
 * 1. if either of p and q are equal to curr , or
 * 2. p is greater and q is lesser than curr (or vice-versa)
 *
 * then curr MUST be LCA
 *
 */

public class lc5_LCA_in_BST {

    public static void main(String[] args) {

        TreeNode root = null;

        root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        // //expected = 6
        // Node p = root.left;
        // Node q = root.right;

        // expected = 2
        TreeNode n1 = root.left;
        TreeNode n2 = root.left.right;

        TreeNode ans = lc5_LCA_in_BST_soln.find(root, n1, n2);
        System.out.println(ans.val);

    }
}

class lc5_LCA_in_BST_soln {

    static TreeNode find(TreeNode curr, TreeNode n1, TreeNode n2) {
        if (curr == null) {
            return null;
        }

        if (n1.val > curr.val && n2.val > curr.val) {
            return find(curr.right, n1, n2);
        } else if (n1.val < curr.val && n2.val < curr.val) {
            return find(curr.left, n1, n2);
        } else {
            return curr;
        }
    }
}

class lc5_LCA_in_BST_soln_rev1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}