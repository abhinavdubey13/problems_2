package tree.classic;

import models.TreeNode;

import java.util.*;

/**
 * check if the given Binary Tree is perfect tree .
 *
 * perfect tree : both the below condition satisfy
 *
 * condition-1 : all nodes are either leaf node or have 2 chilren
 * condition-2 : all leaf nodes at same level
 *
 */

/**
 *
 * approach : recursive check if both children are present or not
 *
 * and at leaf  , noted the level of that leaf
 *
 * TC - O(n)
 * SC - Max(possible leaf levels , height)
 *
 */


public class p21_check_perfect_tree {

    public static void main(String[] args) {
        //true
        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

        //false : condition-1 (true) and condition-2(false)
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(8);
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(15);


        System.out.println(new p21_check_perfect_tree_soln().check(root));
    }
}


class p21_check_perfect_tree_soln {

    Set<Integer> hset;
    boolean all_have_2_children;

    boolean check(TreeNode root) {
        if (root == null) {
            return true;
        }


        hset = new HashSet<>();
        all_have_2_children=true;
        helper(root, 0);
        return all_have_2_children && hset.size() == 1;
    }


    void helper(TreeNode curr, int level) {
        if (curr == null) {
            return;
        }

        if (curr.right == null && curr.left == null) {
            hset.add(level);
            return;
        }


        all_have_2_children = (all_have_2_children && curr.left != null && curr.right != null);
        helper(curr.left, level + 1);
        helper(curr.right, level + 1);
    }
}
