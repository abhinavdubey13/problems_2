package tree.classic_2;

import models.TreeNode;

import java.util.Stack;

/**
 *
 * post order traversal
 *
 * using 1 stack
 *
 */

public class p3_iterative_post_order {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);


//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);

        p3_iterative_post_order_soln.postOrder(root);
    }
}



class p3_iterative_post_order_soln {

    static void postOrder(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> stk = new Stack<>();
        TreeNode ptr = root;

        while(stk.size() >0 || ptr!=null){

            while(ptr != null){
                stk.push(ptr);
                ptr=ptr.left;
            }

            //next step depends on if ptr is leaf
            //if leaf , we may be on post-order trail
            //else goto ptr right child
            if(stk.peek().right==null){
                ptr =stk.pop();
                System.out.print(ptr.val + " ");
                while(stk.size()>0 && stk.peek().right==ptr){
                    ptr =stk.pop();
                    System.out.print(ptr.val + " ");
                }
                ptr =(stk.size()>0)?stk.peek().right:null;
            }else{
                ptr=stk.peek().right;
            }

        }

    }
}
