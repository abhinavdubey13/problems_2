package tree.a_done_classic;

import models.TreeNode;

import java.util.*;


/**
 * 
 * lc : 103
 * 
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 
 * 
 */

/**
 *
 * approach-1 : iterative using 2 stacks
 *
 * approach-2 : using recursion , maintaining seperate list for each level
 *
 *
 */


public class p8_level_order_spiral {

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

        p8_level_order_spiral_using_stk.fun(root);
        System.out.println();


    }
}


class p8_level_order_spiral_using_stk {

    static void fun(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> l2r = new Stack<>();
        Stack<TreeNode> r2l = new Stack<>();

        l2r.add(root);

        while (l2r.size() > 0 || r2l.size() > 0) {

            if (l2r.size() > 0) {
                while (l2r.size() > 0) {
                    TreeNode popped = l2r.pop();
                    System.out.print(popped.val + " ");

                    if (popped.right != null)
                        r2l.add(popped.right);
                    if (popped.left != null)
                        r2l.add(popped.left);
                }
            } else {
                while (r2l.size() > 0) {
                    TreeNode popped = r2l.pop();
                    System.out.print(popped.val + " ");

                    if (popped.left != null)
                        l2r.add(popped.left);
                    if (popped.right != null)
                        l2r.add(popped.right);

                }
            }

        }


    }


}


class p8_level_order_spiral_using_recursion {
    List<List<Integer>> ans;

    List<List<Integer>> function(TreeNode root) {
        ans = new LinkedList<>();
        helper(root, 0);
        return ans;
    }

    void helper(TreeNode root , int level){
        if(root == null){
            return;
        }

        if(ans.size() < level+1){
            ans.add(new LinkedList<>());
        }

        if(level%2==0){
            ans.get(level).add(root.val);
        }else{
            ans.get(level).add(0,root.val);
        }

        helper(root.left , level+1);
        helper(root.right , level+1);
    }


}
