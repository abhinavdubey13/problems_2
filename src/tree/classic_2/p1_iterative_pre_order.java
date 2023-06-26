package tree.classic_2;

import java.util.*;

import models.*;

/**
 *
 * iterative pre order traversal
 *
 */

public class p1_iterative_pre_order {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        p1_iterative_pre_order_soln.preOrder(root);
        

    }
}

class p1_iterative_pre_order_soln {

    static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stk = new Stack<>();
        TreeNode ptr = root;

        while (stk.size() > 0 || ptr != null) {

            while (ptr != null) {
                System.out.print(ptr.val + " ");
                stk.push(ptr);
                ptr = ptr.left;
            }

            if (stk.size() > 0) {
                ptr = stk.pop();
                ptr = ptr.right;
            }

        }

    }

}

