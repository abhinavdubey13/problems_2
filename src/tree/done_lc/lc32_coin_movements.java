package tree.done;

import models.TreeNode;

/**
 *
 * leetcode id : 979
 * 
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/ 
 *
 * You are given the root of a binary tree with n nodes where each node in the tree has node.val coins and there are n coins total.
 *
 *  In one move, we may choose two adjacent nodes and move one coin from one node to another. (A move may be from parent to child, or from child to parent.)
 *
 * Return the number of moves required to make every node have exactly one coin.
 *
 *
 * ==========
 * example :
 * ==========
 *
 * i/p :
 * o/p :
 *
 */

/**
 * ============
 * approach : 1
 * =============
 *
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/256136/Java-Recursion-REALLY-easy-to-understand!!
 *
 * For each node, we use an int array to record the information
 *
 * [# of nodes in the subtree (include itself), # of total coins in the subtree
 * (include itself)].
 *
 * Then we know that for a certain node, if there are more coins than nodes in
 * the subtree,
 *
 * the node must "contribute" the redundant coins to its parent.
 *
 * Else, if there are more nodes than coins in the subtree, then the node must
 * take some coins from the parent.
 *
 * Both of these two operations will create moves in the tree.
 *
 * And we just need to add the absolute value of the (# nodes - # coins) to the
 * final result
 *
 * because the move can be "contribute" or "take"
 *
 * ===============
 * TC = O(n)
 * SC = O(n)
 *
 *
 */

public class lc32_coin_movements {
}

class lc32_coin_movements_soln {

    class ReturnObj {
        int node_count;
        int coin_count;

        ReturnObj(int node_count, int coin_count) {
            this.node_count = node_count;
            this.coin_count = coin_count;
        }
    }

    int ANSWER;

    int find(TreeNode root) {
        this.ANSWER = 0;
        helper(root);
        return this.ANSWER;
    }

    ReturnObj helper(TreeNode node) {
        if (node == null) {
            return new ReturnObj(0, 0);
        }
        ReturnObj left = helper(node.left);
        ReturnObj right = helper(node.right);

        this.ANSWER += Math.abs(left.node_count - left.coin_count) + Math.abs(right.node_count - right.coin_count);
        return new ReturnObj(1 + left.node_count + right.node_count, node.val + left.coin_count + right.coin_count);
    }

}
