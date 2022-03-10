package tree;
import models.TreeNode;



/**
 *
 * lc: 1448
 *
 * Given a binary tree root,
 *
 * a node X in the tree is named good if :
 * in the path from root to X there are no nodes with a value greater than X.
 *
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
