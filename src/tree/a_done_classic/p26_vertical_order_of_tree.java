package tree.a_done_classic;

import models.TreeNode;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
 *
 * Given a binary tree, print it vertically
 *
 */



/**
 *
 *
 * using Hash_map and queue
 * key : int representing a verical level
 * value : List of nodes at that vertical level
 *
 * use preorder traversal to form the map 1st and then print map , key-by-key
 *
 * TreeMap : bcz we want sorted order of keys
 *
 *
 * =================================
 * let total nodes in tree = n
 *
 * TC = O(n)
 * SC = O(n)
 *
 *
 *
 */


public class p26_vertical_order_of_tree {


    public static void main(String[] args) {

        // expected : 2 1 3 6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        new p26_vertical_order_of_tree_soln().print_vertical(root);
    }
}


class p26_vertical_order_of_tree_soln {

    Map<Integer, List<Integer>> hmap;

    void print_vertical(TreeNode root) {

        hmap = new TreeMap<>();
        get_map(root, 0);

        //printing logic
        for (Map.Entry<Integer, List<Integer>> entry : hmap.entrySet()) {
            List<Integer> nodes_at_a_vertical_level = entry.getValue();
            for (Integer i : nodes_at_a_vertical_level) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
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

