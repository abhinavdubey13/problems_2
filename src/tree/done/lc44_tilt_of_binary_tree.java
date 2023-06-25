
package tree.done;
import java.util.*;
import models.TreeNode;

/**
 * 
 * leetcode id : 563
 * 
 * https://leetcode.com/problems/binary-tree-tilt/
 * 
 * Given the root of a binary tree, return the sum of every tree TreeNode's tilt.
 * 
 * The tilt of a tree TreeNode is the absolute difference between the sum of all left subtree TreeNode values and all right subtree TreeNode values. 
 * 
 * If a TreeNode does not have a left child, then the sum of the left subtree TreeNode values is treated as 0. 
 * 
 * The rule is similar if there the TreeNode does not have a right child.
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
 * set all tilt at each TreeNode
 * 
 * then find sum of all those tilts
 * 
 * ============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class lc44_tilt_of_binary_tree {

  public static void main(String[] args) {
    // tree
    TreeNode root;
    root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(5);

    root.right = new TreeNode(9);
    root.right.right = new TreeNode(7);

    int answer = new lc44_tilt_of_binary_tree_soln_soln().findTilt(root);
    System.out.println(answer);
  }

}

class lc44_tilt_of_binary_tree_soln_soln {

  int ans;

  public int findTilt(TreeNode root) {
    ans = 0;
    helper(root);
    return ans;
  }

  public int helper(TreeNode curr) {
    if (curr == null) {
      return 0;
    }

    int l = helper(curr.left);
    int r = helper(curr.right);
    ans += Math.abs(l - r);
    return curr.val + l + r;
  }
}
