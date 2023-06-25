package tree.done_lc;

import models.TreeNode;

/**
 * leetcode id : 450
 *
 * 
 * https://leetcode.com/problems/delete-node-in-a-bst/
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 *
 * Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
 *
 *
 * ==========
 * example :
 * ==========
 *
 * i/p :
 * o/p :
 */

/**
 * ============
 * approach : 1
 * =============
 *
 * https://www.youtube.com/watch?v=gcULXE7ViZw&ab_channel=mycodeschool
 *
 * node to be deleted can be one of the 3 :
 *
 * 1. it is a leaf node : do nothing , remove it by making parent's left/right as null
 * 2. it has only 1 child : simply return the non-null child
 *
 * 3. it has both chldren
 *    a. find min in RST of the node to be deleted
 *    b. copy its data to the node to be deleted
 *    c. now delete the min in RST (it will be either 1 or 2 above)
 *
 * ===============
 * TC = O(ht)
 * SC = O(ht)
 *
 *
 */

public class lc35_delete_a_given_node_in_BST {
}


class lc35_delete_node_in_BST_soln {

    TreeNode delete_node(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right = delete_node(root.right, key); //bcz root's right may get updated
        } else if (root.val > key) {
            root.left = delete_node(root.left, key); //bcz root's left may get updated
        } else {

            if (root.left == null) {
                return root.right; //handles case 1 and 2
            } else if (root.right == null) {
                return root.left; //handles case 1 and 2
            } else {
                TreeNode min_in_rst = get_min_in_rst(root.right);
                root.val = min_in_rst.val; //copy
                root.right = delete_node(root.right, min_in_rst.val); //RST will get modified , obviously bcz we found min in RST
            }
        }

        return root;
    }

    TreeNode get_min_in_rst(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
