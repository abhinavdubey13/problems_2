package tree.classic;
import models.TreeNode;

/**
 * given in-order and post -order of a binary tree
 * construct the tree
 */

/**
 * similar to create using in and pre
 *
 * but here we goto right child first and begin POST_IDX from last : n-1
 * =================================
 * let total nodes in tree = n
 *
 * TC = O(n)
 * SC = O(n)
 *
 *
 */

public class p9_tree_using_in_and_post {

    public static void main(String[] args) {
        int[] in_order = {11, 12, 13, 14, 16, 15};
        int[] post_order = {11, 13, 12, 16, 15, 14};

        TreeNode root = new p9_tree_using_in_and_post_soln().construct_tree(in_order, post_order);
        root.print_in_order(root);
    }
}



class p9_tree_using_in_and_post_soln {

    int POST_IDX;

    TreeNode construct_tree(int[] in, int[] pre) {
        this.POST_IDX = in.length - 1;
        return this.construct_tree_util(in, pre, 0, in.length - 1);

    }

    TreeNode construct_tree_util(int[] in, int[] post, int in_start, int in_end) {

        if (in_start > in_end) {
            return null;
        }

        if (in_start == in_end) {
            return new TreeNode(post[POST_IDX--]);
        }


        int data = post[POST_IDX--];
        TreeNode root = new TreeNode(data);
        int index_in_inorder = find_in_inorder(in, data);


        root.right = construct_tree_util(in, post, index_in_inorder + 1, in_end);
        root.left = construct_tree_util(in, post, in_start, index_in_inorder - 1);
        return root;
    }


    int find_in_inorder(int[] arr, int x) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = (arr[i] == x) ? i : result;
        }
        return result;
    }
}

