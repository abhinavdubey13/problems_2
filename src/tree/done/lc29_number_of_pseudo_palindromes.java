package tree.done;

import models.TreeNode;

/**
 *
 * lc: 1457
 * 
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 *
 * Given a binary tree where node values are digits from 1 to 9.
 *
 * Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
 *
 * A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
 *
 *
 */

/**
 *
 * ===========
 * approach :
 * ===========
 *
 *
 *
 * use the fact that in a palindrome , atmost 1 odd occurnace of a number can be there
 *
 *
 * ie all digits will occur even number of times , atmost 1 odd occurance is allwd
 *
 * 3-3-3
 * 3-4-5-4-3
 *
 * TC = O(n)
 * SC = O(ht)
 *
 */


public class lc29_number_of_pseudo_palindromes {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.left.left = new TreeNode(3);

        root.right = new TreeNode(1);
        root.right.right = new TreeNode(1);

        int answer = new lc29_number_of_pseudo_palindromes_soln().find(root);
        System.out.println(answer);

    }
}


class lc29_number_of_pseudo_palindromes_soln {

    int ANSWER;
    int[] ARR;

    int find(TreeNode root) {

        if (root == null) {
            return 1;
        }

        this.ANSWER = 0;
        this.ARR = new int[10]; //0....9
        this.helper(root);
        return this.ANSWER;
    }

    void helper(TreeNode curr) {
        if (curr == null) {
            return;
        }

        this.ARR[curr.val]++;

        //if leaf , check for palindrome
        if (curr.left == null && curr.right == null) {
            this.check_palin();
        } else {
            helper(curr.left);
            helper(curr.right);
        }

        this.ARR[curr.val]--;
    }



    //takes O(1) time
    void check_palin() {
        int count_odd = 0;
        for (int i : this.ARR) {
            count_odd += (i % 2 == 1) ? 1 : 0;
        }
        this.ANSWER += (count_odd < 2) ? 1 : 0;
    }


}