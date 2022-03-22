package tree;

import models.TreeNode;

import java.util.*;


/**
 *
 * lc : 863
 *
 * We are given a binary tree (with root node root), a target node, and an integer value K
 *
 * Return a list of the values of all nodes that have a distance K from the target node.
 *
 * The answer can be returned in any order.
 *
 *
 */

/**
 *
 * ===========
 * approach :
 * ===========
 *
 *
 * As we know, if the distance from a node to target node is k,
 * the distance from its child to the target node is k + 1 unless the child node is closer to the target node
 * which means the target node is in it's subtree.
 *
 * To avoid this situation, we need to travel the tree first to find the path from root to target, to:
 * store the value of distance in hashamp from the all nodes in that path to target
 *
 * Then we can easily use dfs to travel the whole tree.
 * Every time when we meet a treenode which has already stored in map, use the stored value in hashmap instead of the value from its parent node.
 *
 * TC = O(n)
 * SC = O(ht)
 *
 */


public class lc31_all_nodes_at_distance_k {

    public static void main(String[] args) {


//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(5);
//        root.left.left = new TreeNode(6);
//        root.left.right = new TreeNode(2);
//        root.left.right.left = new TreeNode(7);
//        root.left.right.right = new TreeNode(4);
//
//        root.right = new TreeNode(1);
//        root.right.left = new TreeNode(0);
//        root.right.right = new TreeNode(8);

        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(2);
        root.right.right.right = new TreeNode(2);

        TreeNode target = root.right;
        int k = 2;

        List<Integer> k_dist = new lc31_all_nodes_at_distance_k_soln().find(root, target, k);
        System.out.println(k_dist);
    }
}

class lc31_all_nodes_at_distance_k_soln {

    Map<TreeNode, Integer> distMap;
    List<Integer> ANSWER;

    public List<Integer> find(TreeNode root, TreeNode target, int k) {

        distMap = new HashMap<>();
        ANSWER = new LinkedList<>();

        this.setDistanceMap(root, target);
        helper(root, distMap.get(root), k);

        return this.ANSWER;
    }


    void helper(TreeNode curr, int dist_from_target, int k) {
        if (curr == null) {
            return;
        }

        int final_dist_from_target = distMap.getOrDefault(curr, dist_from_target);

        if (final_dist_from_target == k) {
            this.ANSWER.add(curr.val);
        }

        helper(curr.left, final_dist_from_target + 1, k);
        helper(curr.right, final_dist_from_target + 1, k);


    }

    int setDistanceMap(TreeNode curr, TreeNode target) {
        if (curr == null) {
            return -1;
        }

        if (curr == target) {
            this.distMap.put(curr, 0);
            return 0;
        }

        int l = setDistanceMap(curr.left, target);
        int r = setDistanceMap(curr.right, target);

        if (l > -1) {
            this.distMap.put(curr, 1 + l);
            return 1 + l;
        } else if (r > -1) {
            this.distMap.put(curr, 1 + r);
            return 1 + r;
        }


        return -1;


    }

}
