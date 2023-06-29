package tree.a_done_classic;

import models.TreeNode;

/**
 *
 * write a function which takes in any 2 nodes of the tree and checks if those 2 are cousins
 *
 * cousin : at same level but different parent
 *
 * if any 1 of the 2 is not a node of the tree , return false
 *
 */

/**
 *
 * using recursive pre-order
 *
 * store level and parent of each node
 *
 */

public class p16_check_cousins {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(15);

        System.out.println(new p16_check_cousins_soln().is_cousin(root,root.left.left, root.right.left)); //true
        System.out.println(new p16_check_cousins_soln().is_cousin(root,root.left, root.right.left)); //false

    }

}


class p16_check_cousins_soln {

    TreeNode parent1;
    TreeNode parent2;
    int level1;
    int level2;


    boolean is_cousin(TreeNode root, TreeNode n1, TreeNode n2) {
        preOrder(root, null, n1, n2, 0);
        return (level1 == level2 && parent1 != parent2);
    }

    void preOrder(TreeNode curr, TreeNode parent, TreeNode n1, TreeNode n2, int level) {
        if (curr == null) {
            return;
        }

        if (curr == n1) {
            parent1 = parent;
            level1 = level;
        } else if (curr == n2) {
            parent2 = parent;
            level2 = level;
        }

        preOrder(curr.left, curr, n1, n2, level + 1);
        preOrder(curr.right, curr, n1, n2, level + 1);
    }

}
