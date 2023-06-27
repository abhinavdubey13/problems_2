package tree.a_done_classic;

import java.util.*;
import models.*;

/**
 * 
 * https://www.geeksforgeeks.org/bottom-view-binary-tree/
 * 
 */

/**
 * 
 * similar to top view , but here we need last TreeNode at each vertical level
 * 
 * 
 * 
 * 
 * 
 */

public class p28_view_bottom {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        p28_view_bottom_soln.solve(root);
    }
}

class p28_view_bottom_soln {

    static void solve(TreeNode currentRoot) {

        Map<Integer, ArrayList<TreeNode>> my_map = new TreeMap<Integer, ArrayList<TreeNode>>();
        get_map_using_preorder(currentRoot, my_map, 0);

        for (Map.Entry<Integer, ArrayList<TreeNode>> entry : my_map.entrySet()) {
            ArrayList<TreeNode> nodes_at_a_vertical_level = entry.getValue();

            int last_idx = nodes_at_a_vertical_level.size() - 1;

            System.out.print(nodes_at_a_vertical_level.get(last_idx).val + " ");
        }
    }

    static void get_map_using_preorder(TreeNode Root, Map<Integer, ArrayList<TreeNode>> my_map, int current_level) {
        if (Root == null) {
            return;
        }

        if (my_map.get(current_level) != null) {
            ArrayList<TreeNode> al = my_map.get(current_level);
            al.add(Root);
        } else {
            ArrayList<TreeNode> al = new ArrayList<TreeNode>();
            al.add(Root);
            my_map.put(current_level, al);
        }

        get_map_using_preorder(Root.left, my_map, current_level - 1);
        get_map_using_preorder(Root.right, my_map, current_level + 1);

    }
}
