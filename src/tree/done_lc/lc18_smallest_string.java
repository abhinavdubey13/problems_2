package tree.done_lc;

import models.TreeNode;

/**
 *
 * lc : 988
 * 
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/
 *
 * Given the root of a binary tree,
 *
 * each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.
 *
 * Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
 *
 * As a reminder, any shorter prefix of a string is lexicographically smaller:
 * for example, "ab" is lexicographically smaller than "aba".
 *
 *
 *
 */


/**
 *
 * top-down recursion
 * 
 * -form string from root to leaf
 * -reverse the string
 * -compare with global answer
 *
 */

public class lc18_smallest_string {

    public static void main(String[] args) {

        //expected : abc
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(2);
//        root.left.right = new TreeNode(1);
//        root.left.right.left = new TreeNode(0);
//        root.right = new TreeNode(1);
//        root.right.left = new TreeNode(0);


//        //expected : dba
//        TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(1);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(4);

        //expected : adz
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(2);


        System.out.println(new lc18_smallest_string_soln().find(root));


    }

}


class lc18_smallest_string_soln {

    String ANSWER;

    String find(TreeNode root) {

        if (root == null) {
            return "";
        }

        if (root.left == null && root.right == null) {
            char c = (char) (97 + root.val);
            String s = "" + c;
            return s;
        }

        this.ANSWER = "";
        this.helper(root, "");

        //String ans = new StringBuilder(this.ANSWER).reverse().toString();
        return this.ANSWER;

    }


    private void helper(TreeNode curr, String str) {
        if (curr == null) {
            return;
        }

        char c = (char) (97 + curr.val);
        String s = str + c;

        if (curr.left == null && curr.right == null) {
            this.check(s);
            return;
        }

        helper(curr.left, s);
        helper(curr.right, s);
    }


    private void check(String str) {

        //reverse b4 comparing
        String reversed = new StringBuilder(str).reverse().toString();

        if (this.ANSWER.equals("")) {
            this.ANSWER = reversed;
            return;
        }

        for (int i = 0, j = 0; i < ANSWER.length() && j < reversed.length(); i++, j++) {
            if (reversed.charAt(j) < ANSWER.charAt(i)) {
                this.ANSWER = reversed;
                return;
            } else if (reversed.charAt(j) == ANSWER.charAt(i)) {
                continue;
            } else if (reversed.charAt(j) > ANSWER.charAt(i)) {
                return;
            }
        }


        if (reversed.length() < this.ANSWER.length()) {
            this.ANSWER = reversed;
        }
    }
}