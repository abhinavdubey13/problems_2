package models;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class TreeNode {

    static private char null_node = 'x';

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public void print_in_order(TreeNode root) {
        if (root != null) {
            print_in_order(root.left);
            System.out.print(root.val + " ");
            print_in_order(root.right);
        }
    }

    public boolean isLeaf() {
        return (this.left == null && this.right == null);
    }

    public static TreeNode getTreeFromIntegerList(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(new TreeNode(arr[0]));

        int idx_to_pick = 0;
        TreeNode ans = null;
        while (q.size() > 0) {
            TreeNode popped = q.poll();

            if (idx_to_pick == 0) {
                ans = popped;
            }

            idx_to_pick++;
            Integer val = getIntegerVal(arr, idx_to_pick);
            if (idx_to_pick < arr.length && val != null) {
                popped.left = new TreeNode(val);
                q.add(popped.left);
            }

            idx_to_pick++;
            val = getIntegerVal(arr, idx_to_pick);
            if (idx_to_pick < arr.length && val != null) {
                popped.right = new TreeNode(val);
                q.add(popped.right);
            }
        }

        return ans;
    }

    static int getIntFromString(String s) {
        return Integer.parseInt(s);
    }

    static Integer getIntegerVal(Integer[] arr, int idx) {
        if (idx < arr.length) {
            return arr[idx];
        }
        return null;
    }

}