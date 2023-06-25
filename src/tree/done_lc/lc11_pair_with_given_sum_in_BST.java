package tree.done;

import models.TreeNode;

import java.util.*;

/**
 * 
 * lc : 653
 * 
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * 
 * Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, 
 * or false otherwise.
 * 
 */

 /**
  * convert bst to sorted list nd use 2 pointer
  * 
  * 
  */

public class lc11_pair_with_given_sum_in_BST {
    public static void main(String[] args) {

        //tree
        TreeNode root;
        root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);

        int sum = 47;
        boolean answer =
                new lc11_pair_with_given_sum_in_BST_soln()
                        .find(root, sum);

        System.out.println(answer);

    }
}


class lc11_pair_with_given_sum_in_BST_soln {

    private List<Integer>inorder;

    boolean find(TreeNode root, int sum) {

        if (root == null || root.isLeaf()) {
            return false;
        }

        inorder = new LinkedList<>();
        get_inorder(root);

        int i = 0, j = inorder.size() - 1;

        while (i < j) {
            int a = inorder.get(i);
            int b = inorder.get(j);
            if (a + b == sum) {
                return true;
            }
            else if (a + b < sum) {
                i++;
            }
            else if (a + b > sum) {
                j--;
            }
        }

        return false;

    }

    private void get_inorder(TreeNode curr) {
        if (curr == null) {
            return;
        }

        get_inorder(curr.left);
        inorder.add(curr.val);
        get_inorder(curr.right);
    }

}
