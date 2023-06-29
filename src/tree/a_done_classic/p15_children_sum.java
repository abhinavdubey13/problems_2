package tree.a_done_classic;

import models.TreeNode;


/**
 *
 * https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
 *
 *
 * Given a binary tree, write a function that returns true if the tree satisfies below property.
 *
 * For every node, data value must be equal to sum of data values in left and right children.
 *
 * Consider data value as 0 for NULL children.
 *
 *
 */

/**
 *
 * approach : recursively check at each node
 *
 *
 */




public class p15_children_sum {

    public static void main(String[] args) {

        //true
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);


        System.out.println(p15_children_sum_soln.check(root));
    }
}


class p15_children_sum_soln {

    static boolean check(TreeNode root){

        //null nd leaf node
        if(root==null || root.left==null && root.right==null){
            return true;
        }


        boolean l = check(root.left);
        boolean r = check(root.right);

        int l_val = (root.left!=null)?root.left.val : 0;
        int r_val = (root.right!=null)?root.right.val :0;
        return (l && r && root.val == l_val + r_val);
    }
}
