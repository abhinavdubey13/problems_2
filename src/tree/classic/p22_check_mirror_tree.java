package tree.classic;

import models.TreeNode;

/**
 *
 * Given two Binary Trees,
 *
 * write a function that returns true if two trees are mirror of each other
 *
 *
 */


/**
 *
 * approach : recursively check if
 *  1. the data is same
 *  2. RST of Left-tree == LST of right-tree
 *  3. LST of Left-tree == RST of right-tree
 *
 * TC - O(n)
 * SC - O(height)
 *
 */


public class p22_check_mirror_tree {

    public static void main(String[] args) {

        //true
        // node leftRoot = new node(10);
        // leftRoot.left = new node(8);
        // leftRoot.right = new node(2);
        // node rightRoot = new node(10);
        // rightRoot.left = new node(2);
        // rightRoot.right = new node(8);

        //true
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);
        b.left = new TreeNode(3);
        b.right = new TreeNode(2);
        b.right.left = new TreeNode(5);
        b.right.right = new TreeNode(4);

        System.out.println(p22_check_mirror_tree_soln.check(a, b));
    }
}


class p22_check_mirror_tree_soln {

    static boolean check(TreeNode r1 , TreeNode r2){
        if(r1==null && r2==null){
            return true;
        }

        if(r1==null || r2==null || r1.val != r2.val){
            return false;
        }

        return  check(r1.left , r2.right) && check(r1.right , r2.left);
    }
}
