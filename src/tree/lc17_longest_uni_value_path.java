package tree;

import models.TreeNode;

/**
 *
 * lc : 687
 *
 * Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value.
 *
 * This path may or may not pass through the root.
 *
 * The length of the path between two nodes is represented by the number of edges between them.
 *
 *
 */

/**
 *
 * ===========
 * approach :
 * ===========
 *
 * recursive
 *
 * from leaf to top
 *
 * maintain wat is the max_path_len and Path_of_what_value
 *
 *
 *
 *
 *
 * TC = O(n)
 * SC = O(ht)
 *
 */

public class lc17_longest_uni_value_path {

    public static void main(String[] args) {

//        //expected 2
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        //expected 4
//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(1);
//        root.right.left = new TreeNode(1);
//        root.right.left.left = new TreeNode(1);
//        root.right.left.right = new TreeNode(1);
//        root.right.right = new TreeNode(1);
//        root.right.right.left = new TreeNode(1);


        int ans = new lc17_longest_uni_value_path_soln().find(root);
        System.out.println(ans);
    }
}


class lc17_longest_uni_value_path_soln {

    private int ANSWER;

    public int find(TreeNode root) {
        this.ANSWER = 0;
        Integer[] res = this.helper(root);
        return this.ANSWER-1;
    }


    private Integer[] helper(TreeNode curr) {
        if (curr == null) {
            return new Integer[]{null, 0};
        }

        Integer[] l = helper(curr.left);
        Integer[] r = helper(curr.right);
        Integer[] return_arr = new Integer[]{curr.val, 1};
        ;

        if (l[0] != null && l[0] == curr.val && r[0] != null && r[0] == curr.val) {
            this.ANSWER = Math.max(this.ANSWER, 1 + l[1] + r[1]);
            return_arr[1] = 1 + Math.max(l[1], r[1]);
        } else if (l[0] != null && l[0] == curr.val) {
            this.ANSWER = Math.max(this.ANSWER, 1 + l[1]);
            return_arr[1] = 1 + l[1];
        } else if (r[0] != null && r[0] == curr.val) {
            this.ANSWER = Math.max(this.ANSWER, 1 + r[1]);
            return_arr[1] = 1 + r[1];
        }  else {
            this.ANSWER = Math.max(this.ANSWER, 1);
            return_arr[1] = 1 ;
        }


        return return_arr;
    }


}
