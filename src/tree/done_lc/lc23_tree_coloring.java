package tree.done_lc;

/**
 * leetcode id : 1145
 *
 * https://leetcode.com/problems/binary-tree-coloring-game/
 * 
 * Two players play a turn based game on a binary tree.
 * We are given the root of this binary tree, and the number of nodes n in the tree.
 *
 * n is odd, and each node has a distinct value from 1 to n.
 *
 *
 * Initially, the first player names a value x with 1 <= x <= n, and the second player names a value y with 1 <= y <= n and y != x.
 * The first player colors the node with value x red, and the second player colors the node with value y blue.
 * Then, the players take turns starting with the first player.
 * In each turn, that player chooses a node of their color (red if player 1, blue if player 2) and colors an uncolored neighbor of the chosen node (either the left child, right child, or parent of the chosen node.)
 *
 * If (and only if) a player cannot choose such a node in this way, they must pass their turn.
 * If both players pass their turn, the game ends, and the winner is the player that colored more nodes.
 *
 *
 * You are the second player.  If it is possible to choose such a y to ensure you win the game, return true.  If it is not possible, return false.
 *
 *
 * ==========
 * example :
 * ==========
 *
 * i/p :
 * o/p :
 */

import models.TreeNode;

/**
 * ============
 * approach : 1
 * ============
 *
 * The first player colors a node, there are at most 3 nodes connected to this node.
 *
 * Its left, its right and its parent. Take this 3 nodes as the root of 3 subtrees.
 *
 * The second player just color any one root, and the whole subtree will be his.
 * And this is also all he can take, since he cannot cross the node of the first player.
 *
 *
 * https://leetcode.com/problems/binary-tree-coloring-game/solutions/350738/easy-to-understand-for-everyone/
 * 
 * =============
 * TC = O(n)
 * SC = O(ht)
 */


public class lc23_tree_coloring {
}


class lc23_tree_coloring_soln {

    static boolean function_util(TreeNode root, int n, int x) {

        if (n < 2) {
            return false;
        }

        TreeNode node_x = function(root, x);

        int size_of_lst_of_x = countNodes(node_x.left);
        int size_of_rst_of_x = countNodes(node_x.right);
        int size_of_parent_other_subtree = n - (size_of_lst_of_x + size_of_rst_of_x + 1);

        if (size_of_parent_other_subtree > n / 2 || size_of_lst_of_x > n / 2 || size_of_rst_of_x > n / 2) {
            return true;
        }

        return false;
    }

    static TreeNode function(TreeNode curr, int x) {
        if (curr == null) {
            return null;
        }

        if (curr.val == x) {
            return curr;
        }

        TreeNode l = function(curr.left, x);
        TreeNode r = function(curr.right, x);


        if (l != null) {
            return l;
        } else {
            return r;
        }

    }


    static int countNodes(TreeNode curr) {
        if (curr == null) {
            return 0;
        }

        int l = countNodes(curr.left);
        int r = countNodes(curr.right);
        return 1 + l + r;
    }
}
