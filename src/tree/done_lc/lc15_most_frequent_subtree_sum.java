package tree.done_lc;

import models.TreeNode;

import java.util.*;

/**
 *
 * lc : 508
 *
 * Given the root of a tree, you are asked to find the most frequent subtree sum.
 *
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 *
 * So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 */

/**
 *
 * ===========
 * approach :
 * ===========
 * recursive
 *
 * pass sum of tree rooted here
 *
 *
 * TC = O(n)
 * SC = O(height)
 *
 */

public class lc15_most_frequent_subtree_sum {
}


class lc15_most_frequent_subtree_sum_soln {


    //<sum , frequency>
    private Map<Integer, Integer> sum_map;

    int[] find(TreeNode root) {
        sum_map = new HashMap<>();
        helper(root);

        List<Integer> my_list = new LinkedList<>();
        int max_frquency_so_far = 0;
        for (Map.Entry<Integer, Integer> entry : sum_map.entrySet()) {

            if (entry.getValue() > max_frquency_so_far) {
                my_list.clear(); //reset , as we have found more frequency
                max_frquency_so_far = entry.getValue();
                my_list.add(entry.getKey());
            } else if (entry.getValue() == max_frquency_so_far) {
                my_list.add(entry.getKey());
            }
        }
        return my_list.stream().mapToInt(i -> i).toArray();
    }


    private int helper(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left_sum = helper(root.left);
        int right_sum = helper(root.right);
        int sum_rooted_here = root.val + left_sum + right_sum;
        Integer sum_present = sum_map.get(sum_rooted_here);

        if (sum_present != null) {
            sum_map.put(sum_rooted_here, sum_present + 1);
        } else {
            sum_map.put(sum_rooted_here, 1);
        }
        return sum_rooted_here;
    }


}
