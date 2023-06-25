
package tree.done;
import java.util.*;
import models.TreeNode;


/**
 * 
 * lc : 1161
 * 
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 * 
 * 
 * Given the root of a binary tree, 
 * 
 * the level of its root is 1, 
 * the level of its children is 2, and so on.
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

class lc41_max_level_sum {

    public static void main(String[] args) {

        TreeNode root;

        //tree-1 : expected = 2
        root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        root.right = new TreeNode(0);

        int x = function_util(root);
        System.out.println(x);
    }

    static int function_util(TreeNode root) {

        Map<Integer, Integer> my_map = new HashMap<>();
        function(root, 1, my_map);

        List<Integer> answer_levels = new ArrayList<>();
        int max_sum_of_level = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : my_map.entrySet()) {
            if (entry.getValue().intValue() > max_sum_of_level) {
                answer_levels.clear();
                answer_levels.add(entry.getKey().intValue());
                max_sum_of_level = entry.getValue().intValue();
            } else if (entry.getValue().intValue() == max_sum_of_level) {
                answer_levels.add(entry.getKey().intValue());
            }
        }

        int answer = Integer.MAX_VALUE;
        for (Integer i : answer_levels) {
            answer = Math.min(answer, i.intValue());
        }
        return answer;
    }

    static void function(TreeNode root, int current_level, Map<Integer, Integer> my_map) {

        if (root == null) {
            return;
        }

        Integer level_sum = my_map.get(current_level);
        if (level_sum == null) {
            my_map.put(current_level, root.val);
        } else {
            int new_sum = level_sum.intValue() + root.val;
            my_map.put(current_level, new_sum);
        }

        function(root.left, current_level + 1, my_map);
        function(root.right, current_level + 1, my_map);

    }

}