package tree.a_done_classic;

import models.TreeNode;

import java.util.*;

/**
 *
 * leetcode id : 297
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 */

/**
 *
 * ===========
 * approach :
 * ===========
 *
 * using level-order (BFS) to convert tree into serialzed string
 *
 * and then using queue to get the tree from string in similar fashion
 *
 * we can also remove trailing NULL_REPRESENTATONS to optimise space
 *
 * ===========
 * TC = O(n)
 * SC = O(n)
 */

public class p29_serialize_deserialize_tree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // String serialized_str = new
        // p29_serialize_deserialize_tree_soln().serialize(root);
        // System.out.println(serialized_str);

        // TreeNode returned_root = new
        // p29_serialize_deserialize_tree_soln().de_serialize(serialized_str);
        // new
        // p29_serialize_deserialize_tree_soln().level_order_traversal(returned_root);

        // revision-class
        String serialized_str = new p29_serialize_deserialize_tree_rev1().serialize(root);
        System.out.println(serialized_str);
        TreeNode returned_root = new p29_serialize_deserialize_tree_rev1().deserialize(serialized_str);
        new p29_serialize_deserialize_tree_soln().level_order_traversal(returned_root);

        System.out.println();
    }
}



class p29_serialize_deserialize_tree_soln {

    final String SEPERATOR = "-";
    final String NULL_NODE_SYMBOL = "x";

    String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        String answer = "";

        // BFS traversal
        while (q.size() > 0) {
            TreeNode popped = q.poll();
            if (popped == null) {
                answer += NULL_NODE_SYMBOL + SEPERATOR;
                continue;
            } else {
                answer += popped.val + SEPERATOR;
            }

            q.offer(popped.left);
            q.offer(popped.right);
        }

        String answerFinal = answer.substring(0, answer.length() - 1); // remove the last seperator
        return answerFinal;
    }

    TreeNode de_serialize(String s) {
        if (s == "" || s == null) {
            return null;
        }

        String[] splitted = s.split(SEPERATOR);
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(splitted[0]));
        q.offer(root);

        int i = 1;
        while (i < splitted.length && q.size() > 0) {

            TreeNode polled = q.poll();

            // left-node
            String curr = splitted[i];
            if (!curr.equals(NULL_NODE_SYMBOL)) {
                polled.left = new TreeNode(Integer.parseInt(curr));
                q.offer(polled.left);
            }

            // right-node
            i++;
            curr = splitted[i];
            if (!curr.equals(NULL_NODE_SYMBOL)) {
                polled.right = new TreeNode(Integer.parseInt(curr));
                q.offer(polled.right);
            }

            i++;
        }

        return root;
    }

    void level_order_traversal(TreeNode root) {
        System.out.println("level order is : ");
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // BFS traversal
        while (q.size() > 0) {
            TreeNode popped = q.poll();
            System.out.print(popped.val + " ");

            if (popped.left != null) {
                q.add(popped.left);
            }
            if (popped.right != null) {
                q.add(popped.right);
            }
        }
    }

}


class p29_serialize_deserialize_tree_rev1 {

    private char null_node = 'x';
    private char seperator = '-';

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        String ans = "";
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            TreeNode popped = q.poll();

            if (popped == null) {
                ans += null_node;
                ans += seperator;
            } else {
                ans += String.valueOf(popped.val);
                ans += seperator;
                q.offer(popped.left);
                q.offer(popped.right);
            }

        }

        // removing extra leaf nodes at last
        int last_non_null_char_idx = 0;
        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) != null_node & ans.charAt(i) != seperator) {
                last_non_null_char_idx = i;
            }
        }
        return ans.substring(0, last_non_null_char_idx + 1);
    }

    TreeNode deserialize(String serialized_str) {
        if (serialized_str == null || serialized_str.length() == 0) {
            return null;
        }

        String[] arr = serialized_str.split("-");
        Queue<TreeNode> q = new LinkedList<>();
        q.add(new TreeNode(getIntFromString(arr[0])));

        int idx_to_pick = 0;
        TreeNode ans = null;
        while (q.size() > 0) {
            TreeNode popped = q.poll();

            if (idx_to_pick == 0) {
                ans = popped;
            }

            idx_to_pick++;
            String val = getVal(arr, idx_to_pick);
            if (idx_to_pick < arr.length && !val.equals(String.valueOf(null_node))) {
                popped.left = new TreeNode(getIntFromString(val));
                q.add(popped.left);
            }

            idx_to_pick++;
            val = getVal(arr, idx_to_pick);
            if (idx_to_pick < arr.length && !val.equals(String.valueOf(null_node))) {
                popped.right = new TreeNode(getIntFromString(val));
                q.add(popped.right);
            }
        }

        return ans;
    }

    private int getIntFromString(String s) {
        return Integer.parseInt(s);
    }

    private String getVal(String[] arr, int idx) {
        if (idx < arr.length) {
            return arr[idx];
        }
        return "";
    }
}
