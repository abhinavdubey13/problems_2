package tree.done;
import models.TreeNode;



/**
 *
 * lc: 1448
 *
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
 * 
 * Given a binary tree root,
 *
 * a node X in the tree is named good if :
 * 
 * in the path from root to X there are no nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 *
 *
 */


/**
 *
 * ===========
 * approach :
 * ===========
 *
 * use recursion
 *
 *
 * at each node , check if node's value os greater than maximum_so_far
 *
 * if yes : result+=1 and update maximum_so_far
 *
 *
 * TC = O(n)
 * SC = O(ht)
 *
 */

public class lc6_count_good_nodes {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int ans = new lc6_count_good_nodes_soln().find(root);
        System.out.println(ans);    }
}


class lc6_count_good_nodes_soln {

    int ANSWER ;

    int find(TreeNode root){
        this.ANSWER=0;
        helper(root , root.val);
        return this.ANSWER;
    }

    private void helper(TreeNode curr , int max_till_now){
        if(curr == null){
            return;
        }

        if(curr.val >= max_till_now){
            ANSWER++;
        }

        helper(curr.left , Math.max(max_till_now , curr.val));
        helper(curr.right , Math.max(max_till_now , curr.val));
    }

}


class lc6_count_good_nodes_soln_rev1 {

    static int answer=0;
    public static int goodNodes(TreeNode root) {
        helper(root , root.val);
        return answer;
    }

    static void helper(TreeNode root , int max_till_now) {
        if(root==null){
            return;
        }

        if(root.val >= max_till_now){
            answer++;
        }

        helper(root.left, Math.max(max_till_now , root.val));
        helper(root.right, Math.max(max_till_now , root.val));
    }
}