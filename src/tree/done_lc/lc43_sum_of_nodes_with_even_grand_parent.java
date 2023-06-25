

package tree.done_lc;
import java.util.*;
import models.TreeNode;

/**
 * 
 * lc : 1315
 * 
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 * 
 * 
 *   
 */

/**
 * 
 * ===========
 * approach :
 * ===========
 *
 * recursion + keep a track of parent & grand-parent
 * TC = O(n)
 * SC = O(max-nodes-at-a-level)
 *
 */

class lc43_sum_of_nodes_with_even_grand_parent {

    public static void main(String[] args) {

        TreeNode root;

        // tree-1 : expected = 18
        root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(9);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(5);

        int result = new lc43_sum_of_nodes_with_even_grand_parent_soln().find(root);
        System.out.println(result);
    }

}

class lc43_sum_of_nodes_with_even_grand_parent_soln {
    int ans;

    public int find(TreeNode root) {
        ans = 0;
        helper(root, null, null);
        return ans;
    }

    void helper(TreeNode curr, TreeNode parent, TreeNode grand_parent) {
        if (curr == null) {
            return;
        }

        if (grand_parent != null && grand_parent.val % 2 == 0) {
            ans += curr.val;
        }

        helper(curr.left, curr, parent);
        helper(curr.right, curr, parent);
    }
}
