package tree.a_done_classic;

import models.TreeNode;

import java.util.Stack;

public class p2_iterative_inorder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        // root.right.right = new TreeNode(6);
        // root.right.right.right = new TreeNode(7);

        p2_iterative_inorder_soln.inOrder(root);
    }
}

class p2_iterative_inorder_soln {

    static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stk = new Stack<>();
        TreeNode ptr = root;

        while (stk.size() > 0 || ptr != null) {

            while (ptr != null) {
                stk.push(ptr);
                ptr = ptr.left;
            }

            if (stk.size() > 0) {
                ptr = stk.pop();
                System.out.print(ptr.val + " ");
                ptr = ptr.right;
            }

        }

    }

}
