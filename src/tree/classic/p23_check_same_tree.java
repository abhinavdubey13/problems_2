package tree.classic;


//Two trees are identical when they have same data and arrangement of data is also same.

import models.TreeNode;

/**
 *
 * approach : recursively check if
 *  1. the data is same
 *  2. LST of Left-tree == LST of right-tree
 *  3. RST of Left-tree == RST of right-tree
 *
 * TC - O(n)
 * SC - O(height)
 *
 */

public class p23_check_same_tree {
}


class p23_check_same_tree_soln {

    static boolean check(TreeNode r1 , TreeNode r2){
        if(r1==null && r2==null){
            return true;
        }

        if(r1==null || r2==null || r1.val != r2.val){
            return false;
        }

        return  check(r1.left , r2.left) && check(r1.right , r2.right);
    }
}
