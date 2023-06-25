package tree.classic_2;

import models.TreeNode;

import java.util.*;


/**
 * Given a Binary Tree, find if there exist edge whose removal creates two trees of equal size.
 * size = number of nodes
 */


/**
 * approach-1 : O(n)
 *
 * maintain a set of possible sub-tree sizes and check if size/2 exists at last
 *
 *
 */

public class p17_check_edge_divide {

    public static void main(String[] args) {

        //true
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(15);

        //false
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(8);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(3);
//
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(15);


        System.out.println(new p17_check_edge_divide_soln().check(root));
    }
}


class p17_check_edge_divide_soln {

    Set<Integer> hset;

    boolean check(TreeNode root) {
        if (root == null) {
            return false;
        }

        hset = new HashSet<>();

        int total_size = helper(root);

        return (total_size % 2 == 0 && hset.contains(total_size / 2));


    }


    int helper(TreeNode curr) {
        if (curr == null) {
            return 0;
        }

        int lsize = helper(curr.left);
        int rsize = helper(curr.right);
        int currSize = 1 + lsize + rsize;

        hset.add(currSize);
        return currSize;
    }


}
