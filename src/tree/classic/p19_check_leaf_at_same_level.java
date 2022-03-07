package tree.classic;

import models.TreeNode;

import java.util.*;

/**
 * Given a Binary Tree, check if all leaves are at same level or not.
 */

/**
 * approach : recursively check the level of all leaf nodes , and add the same to a set
 * if at last , set has only 1 entry : all leaf at same level
 * else : not at same level
 *
 * TC - O(n)
 * SC - O(height)
 */

public class p19_check_leaf_at_same_level {
}


class p19_check_leaf_at_same_level_soln {

    Set<Integer>hset;
    boolean check(TreeNode root){
        if(root==null){
            return true;
        }

        hset=new HashSet<>();
        helper(root,0);
        return hset.size()==1;
    }

    void helper(TreeNode curr , int level){
        if(curr==null){
            return;
        }

        //leaf node
        else if(curr.left==null && curr.right==null){
            hset.add(level);
            return;
        }

        helper(curr.left , level+1);
        helper(curr.right , level+1);
    }
}
