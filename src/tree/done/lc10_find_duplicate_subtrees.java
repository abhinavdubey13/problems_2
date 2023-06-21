package tree.done;

import models.TreeNode;

import java.util.*;

/**
 *
 * leetcode id : 652
 *
 * Given the root of a binary tree, return all duplicate subtrees.
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 *
 * Two trees are duplicate if they have the same structure with the same node values.
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
 * 1. A unique sub-tree can be uniquely identified by its serialized string;
 *
 * 2. using post order traversal we can gradualy collect all unique tree-serializations with their associated nodes, with 1 traversal;
 *
 * 3.then you can see if there is any serialization is associated with more than 1 sub-tree nodes, then you know there is duplicated sub-tree nodes;
 *
 * ===============
 * TC = O(n)
 * SC = O(n)
 *
 *
 */

public class lc10_find_duplicate_subtrees {
    public static void main(String[] args) {

        //tree
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);

        root.right.right = new TreeNode(4);

        List<TreeNode> answer = new lc10_find_duplicate_subtrees_soln().find(root);
        for (TreeNode n : answer) {
            System.out.print(n.val + " ");
        }
        System.out.println();

    }
}


class lc10_find_duplicate_subtrees_soln {

    Map<String, TreeNode> hmap;
    List<TreeNode> answer;

    List<TreeNode> find(TreeNode root) {
        answer = new LinkedList<>();
        hmap = new HashMap<>();
        if (root == null) {
            return answer;
        }

        helper(root);
        for (Map.Entry<String, TreeNode> e : hmap.entrySet()) {
            if (e.getValue() != null) {
                answer.add(e.getValue());
            }
        }

        return answer;
    }


    private String helper(TreeNode curr) {
        if(curr==null){
            return "";
        }

        String post_order_lst = helper(curr.left);
        String post_order_rst = helper(curr.right);

        String return_val = post_order_lst + post_order_rst + String.valueOf(curr.val);

        if (!hmap.containsKey(return_val)) {
            //encounter 1st time , set value as null
            hmap.put(return_val, null);
        } else {
            //encounter 2nd time , set value as node
            hmap.put(return_val, curr);
        }

        return return_val;
    }
}
