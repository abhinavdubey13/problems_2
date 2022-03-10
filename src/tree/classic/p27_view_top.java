package tree.classic;


import models.TreeNode;

import java.util.*;

/**
 * given a binary tree , print its top order
 * <p>
 * https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/?ref=lbp
 */


/**
 *
 * using vertical order solution
 *
 * print 1st node of each vertical level
 *
 * TreeMap : bcz we want sorted order of keys
 *
 * =================================
 * let total nodes in tree = n
 *
 * TC = O(n)
 * SC = O(n)
 *
 */


public class p27_view_top {


    public static void main(String[] args) {


        // expected : 2 1 3 6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);


        new p27_view_top_soln().print_vertical(root);
        System.out.println();
    }


}


class p27_view_top_soln {

    Map<Integer, List<Integer>> hmap;

    void print_vertical(TreeNode root) {

        hmap = new TreeMap<>();
        get_map(root, 0);

        //printing logic
        for (Map.Entry<Integer, List<Integer>> entry : hmap.entrySet()) {
            List<Integer> nodes_at_a_vertical_level = entry.getValue();
            System.out.print(nodes_at_a_vertical_level.get(0) + " ");
        }

        System.out.println();
    }


    private void get_map(TreeNode curr, int level) {
        if (curr == null) {
            return;
        }

        if (!hmap.containsKey(level)) {
            hmap.put(level, new LinkedList<>());
        }
        hmap.get(level).add(curr.val);
        get_map(curr.left, level - 1);
        get_map(curr.right, level + 1);
    }


}
