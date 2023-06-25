package tree.done;

import java.util.*;

/**
 * leetcode id : 1104
 *
 * https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/
 * 
 * In an infinite binary tree where every node has two children, the nodes are labelled in row order.
 *
 * In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right,
 *
 * while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.
 *
 * Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.
 *
 *
 * ==========
 * example :
 * ==========
 *
 * i/p :
 * o/p :
 */

/**
 * ============
 * approach : 1
 * ============
 *
 *
 * if the trr was not zig zag , it was an easy qstion , bcz pattern was clear
 * parent = node_data/2
 *
 *
 * here we need to find pattern , just like above secenario
 * parent = (max number at current level + min number at current level) -
 * node_data
 *
 * ============
 * TC = O(log n)
 * SC = O(log n)
 *
 *
 */

public class lc36_path_in_zig_zag_tree {
    public static void main(String[] args) {
        int key = 14;
        List<Integer> ans = new lc36_path_in_zig_zag_tree_soln_rev1().function(key);
        for (Integer i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}

class lc36_path_in_zig_zag_tree_soln {

    List<Integer> function(int node_data) {

        List<Integer> answer = new LinkedList<>();

        int max_in_level = 1;
        int level = 0;

        // find the level at which label
        while (max_in_level < node_data) {
            max_in_level = max_in_level * 2 + 1;
            level++;
        }

        answer.add(0, node_data);

        while (level >= 0) {
            int min_at_this_level = (int) Math.pow(2, level);
            int max_at_this_level = 2 * min_at_this_level - 1;

            node_data = (min_at_this_level + max_at_this_level - node_data) / 2;

            if (node_data > 0) {
                answer.add(0, node_data);
            }
            level--;
        }

        return answer;
    }

}

class lc36_path_in_zig_zag_tree_soln_rev1 {
    List<Integer> function(int key) {

        // level-1 : [1-1] => [1,1]
        // level-2* : [2^1 - 2^2-1] => [2,3]
        // level-3 : [2^2 - 2^3-1] => [4-7]
        // level-4* : [2^3 - 2^4-1] => [8-15]
        // level-n : [2^(n-1) - 2^n-1]

        List<Integer> ans = new LinkedList<>();
        ans.add(key);
        int node_level = get_node_level(key);
        int parent = key;
        while (key > 1) {
            int level_min_val = (int) Math.pow(2, node_level - 1);
            int level_max_val = ((int) Math.pow(2, node_level) - 1);
            parent = (level_max_val + level_min_val - key) / 2;
            node_level -= 1;
            ans.add(0, parent);
            key = parent;
        }

        return ans;
    }

    int get_node_level(int key) {
        for (int i = 1;; i++) {
            if ((int) Math.pow(2, i) > key) {
                return i;
            }
        }
    }

}
