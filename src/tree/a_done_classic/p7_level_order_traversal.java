package tree.a_done_classic;

import models.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class p7_level_order_traversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(9);
        root.left.left = new TreeNode(11);
        root.left.left.right = new TreeNode(15);

        root.right = new TreeNode(-10);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(21);
        root.right.left.left = new TreeNode(18);
        root.right.right.right = new TreeNode(19);

        p7_level_order_traversal_soln.fun(root);
        System.out.println();
    }
}



class p7_level_order_traversal_soln {


    static void fun(TreeNode root){
        if(root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            TreeNode polled = q.poll();
            System.out.print(polled.val + " ");

            if(polled.left!=null){
                q.add(polled.left);
            }

            if(polled.right!=null){
                q.add(polled.right);
            }
        }
    }
}
