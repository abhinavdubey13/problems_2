package tree;
import models.TreeNode;

/**
 *
 * leetcode : 112
 *
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 *
 */

/**
 *
 * using recursion
 *
 */

public class lc1_path_sum {

    public static void main(String[] args){

        //tree-1
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//
//        root.right = new TreeNode(8);
//        root.right.left = new TreeNode(8);
//        root.right.right = new TreeNode(4);
//        root.right.right.right = new TreeNode(1);
//        System.out.println(lc1_path_sum_soln.hasPathSum(root , 22));


        //tree-2
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(lc1_path_sum_soln.hasPathSum(root , 5));


        //tree-3
//        TreeNode root = new TreeNode(1);
//        System.out.println(lc1_path_sum_soln.hasPathSum(root , 1));


    }
}



class lc1_path_sum_soln{

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null){
            return false;
        }

        //tree has only 1 node , root is leaf node
        if(root.left==null && root.right==null){
            return root.val ==targetSum;
        }

        boolean l = check(root.left , targetSum - root.val);
        boolean r = check(root.right , targetSum - root.val);

        return  l || r;
    }


    private static boolean check(TreeNode curr , int sumLeft){
        //if end of tree
        if(curr==null){
            return false;
        }

        //if leaf
        if(curr.left==null && curr.right==null){
            return curr.val ==sumLeft;
        }

        boolean l = check(curr.left , sumLeft - curr.val);
        boolean r = check(curr.right , sumLeft - curr.val);

        return  l || r;
    }

}