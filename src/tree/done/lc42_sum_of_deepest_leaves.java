
package tree.done;
 
import java.util.*;
import models.TreeNode;

/**
 * 
 * leetcode id : 1302
 * 
 * https://leetcode.com/problems/deepest-leaves-sum/
 *
 * Given a binary tree, return the sum of values of its deepest leaves.
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
 * =============
 * 
 * globally maintian 2 variables
 * 
 * 1. max level
 * 2. sum of leaves at max level (answer)
 * 
 * ===============
 * TC = O(n)
 * SC = O(ht)
 * 
 * 
 */

public class lc42_sum_of_deepest_leaves {

  static int MOVES;

  public static void main(String[] args) {

    // //expected = 10
    // TreeNode root;
    // root = new TreeNode(0);
    // root.left = new TreeNode(0);
    // root.left.left = new TreeNode(4);
    // root.left.right = new TreeNode(2);
    // root.right = new TreeNode(0);
    // root.right.right = new TreeNode(0);

    // //expected = 2
    // TreeNode root;
    // root = new TreeNode(3);
    // root.left = new TreeNode(0);  
    // root.right = new TreeNode(0);

    //  //expected = 3
    //  TreeNode root;
    //  root = new TreeNode(0);
    //  root.left = new TreeNode(3);  
    //  root.right = new TreeNode(0);

    // //expected = 2
    // TreeNode root;
    // root = new TreeNode(1);
    // root.left = new TreeNode(0);  
    // root.right = new TreeNode(2);

    // //expected = 4
    // TreeNode root;
    // root = new TreeNode(1);
    // root.left = new TreeNode(0);
    // root.left.right = new TreeNode(3);
    // root.right = new TreeNode(0);


    //expected = 4
    TreeNode root;
    root = new TreeNode(0);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(0);


    int answer = function_util(root);
    System.out.println("total : " + answer);

  }

  static int function_util(TreeNode root) {

    MOVES = 0;
    int l = function(root.left);
    int r = function(root.right);

    root.val = root.val + l + r;

    int upwards = MOVES;

    System.out.println("upwards : " + upwards);

    function2(root, 0);

    System.out.println("downwards : " + (MOVES - upwards));

    return MOVES;
  }

  static int function(TreeNode root) {

    if (root == null) {
      return 0;
    }

    int excess_lst = function(root.left);
    int excess_rst = function(root.right);

    root.val = root.val + excess_lst + excess_rst;

    int returned_from_here = 0;

    if (root.val > 1) {
      returned_from_here = root.val - 1;
      root.val = 1;
      MOVES += returned_from_here;
    }

    return returned_from_here;
  }

  static void function2(TreeNode root, int level) {
    if (root == null) {
      return;
    }

    if (root.val == 0) {
      MOVES += level;
    }

    function2(root.left, level + 1);
    function2(root.right, level + 1);

  }

}