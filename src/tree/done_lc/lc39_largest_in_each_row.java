
package tree.done_lc;

import models.TreeNode;

import java.util.*;

/**
 * 
 * leetcode id : 515
 * 
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 * 
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
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
 * =============
 * 
 * using BFS (iterative level-order travarsal)
 * 
 * ==============
 * TC = O(n)
 * SC = O(n)
 * 
 * 
 */

public class lc39_largest_in_each_row {

  public static void main(String[] args) {

    // tree
    TreeNode root;
    root = new TreeNode(20);
    root.left = new TreeNode(8);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(12);
    root.left.right.left = new TreeNode(10);
    root.left.right.right = new TreeNode(14);

    root.right = new TreeNode(22);
    root.right.right = new TreeNode(25);

    List<Integer> answer = function(root);
    for (Integer i : answer) {
      System.out.print(i + " ");
    }
    System.out.println();

  }

  static List<Integer> function(TreeNode root) {

    List<Integer> answer = new ArrayList<>();

    if (root == null) {
      return answer;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    answer.add(root.val);

    while (q.size() > 0) {
      int size = q.size();
      Integer max_i = null;

      for (int i = 0; i < size; i++) {
        TreeNode removed = q.poll();

        if (removed.left != null) {
          max_i = (max_i == null) ? removed.left.val : Math.max(max_i.intValue(), removed.left.val);
          q.add(removed.left);
        }

        if (removed.right != null) {
          max_i = (max_i == null) ? removed.right.val : Math.max(max_i.intValue(), removed.right.val);
          q.add(removed.right);
        }

      }

      if (max_i != null) {
        answer.add(max_i);
      }

    }

    return answer;

  }

}