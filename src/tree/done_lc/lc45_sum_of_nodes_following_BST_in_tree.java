
package tree.done_lc;

import java.util.*;
import models.TreeNode;

/**
 * 
 * leetcode id : 1373
 * 
 * 
 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/description/
 * 
 * 
 * Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).
 * 
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees
 * 
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
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class lc45_sum_of_nodes_following_BST_in_tree {

  public static void main(String[] args) {
    TreeNode root = TreeNode.getTreeFromIntegerList(new Integer[] { 4, 3, null,
        1, 2 });

    // TreeNode root = TreeNode.getTreeFromIntegerList(new Integer[] { -4, -2, -5
    // });
    // TreeNode root = TreeNode
    // .getTreeFromIntegerList(new Integer[] { 1, 4, 3, 2, 4, 2, 5, null, null,
    // null, null, null, null, 4, 6 });

    // TreeNode root = TreeNode
    // .getTreeFromIntegerList(new Integer[] { 4, 8, null, 6, 1, 9, null, -5, 4,
    // null, null, null, -3, null, 10 });

    int answer = new lc45_sum_of_nodes_following_BST_in_tree_soln().find(root);
    System.out.println(answer);
  }

}

class lc45_sum_of_nodes_following_BST_in_tree_soln {

  class HelperClass {
    boolean is_bst;
    Integer largest;
    Integer smallest;
    int sum_of_keys_in_bst;

    HelperClass(boolean is_bst, Integer largest, Integer smallest, int sok) {
      this.sum_of_keys_in_bst = sok;
      this.is_bst = is_bst;
      this.largest = largest;
      this.smallest = smallest;
    }

    HelperClass() {
      this.sum_of_keys_in_bst = 0;
      this.is_bst = true;
      this.largest = Integer.MIN_VALUE;
      this.smallest = Integer.MAX_VALUE;
    }
  }

  int ans = 0;

  public int find(TreeNode root) {
    ans = 0;
    helper(root);
    return ans;
  }

  public HelperClass helper(TreeNode curr) {
    if (curr == null) {
      return new HelperClass();
    }

    HelperClass curr_helper = new HelperClass();
    HelperClass l = helper(curr.left);
    HelperClass r = helper(curr.right);

    if (l.is_bst && r.is_bst && l.largest < curr.val && curr.val < r.smallest) {
      curr_helper.is_bst = true;
      curr_helper.largest = Math.max(curr.val, r.largest);
      curr_helper.smallest = Math.min(curr.val, l.smallest);
      curr_helper.sum_of_keys_in_bst = curr.val + r.sum_of_keys_in_bst + l.sum_of_keys_in_bst;
    } else {
      curr_helper.is_bst = false;
      curr_helper.sum_of_keys_in_bst = Math.max(r.sum_of_keys_in_bst, l.sum_of_keys_in_bst);
    }

    ans = Math.max(ans, curr_helper.sum_of_keys_in_bst);
    return curr_helper;
  }
}
