package tree;

import models.TreeNode;

import java.util.*;

/**
 *
 * lc : 1161
 *
 * Given the root of a binary tree,
 *
 * the level of its root is 0,
 * the level of its children is 1, and so on.
 *
 *
 *
 * Return the level whose sum is maximum
 *
 *
 * NOTE : if sum of 2 level is same (and maximum) return the smaller of those levels
 *
 *
 */

/**
 *
 * ===========
 * approach :
 * ===========
 *
 * using hashmap
 *
 *
 * TC = O(n)
 * SC = O(ht + number of levels)
 *
 */



public class lc7_find_level_whose_sum_is_max {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        root.right = new TreeNode(0);

        int x = new lc7_find_level_whose_sum_is_max_soln().find(root);
        System.out.println(x);
    }

}


class lc7_find_level_whose_sum_is_max_soln {

    Map<Integer,Integer>level_sum_map;

    int find(TreeNode root) {
        level_sum_map = new HashMap<>();
        helper(root, 0);
        int answer_level = -1;
        int max_sum = -1;
        for (Map.Entry<Integer,Integer>e : level_sum_map.entrySet()) {
            if (e.getValue() >= max_sum) {
                max_sum = e.getValue();
                answer_level = e.getKey();
            }
        }
        return answer_level;
    }


    private void helper(TreeNode curr, int level) {

        if (curr == null) {
            return;
        }

        Integer curr_level_sum = level_sum_map.get(level);
        if (curr_level_sum!=null) {
            level_sum_map.put(level  , curr_level_sum + curr.val);
        } else {
            level_sum_map.put(level , curr.val);
        }

        helper(curr.left, level + 1);
        helper(curr.right, level + 1);

    }

}
