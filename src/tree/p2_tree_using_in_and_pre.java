package tree;
import models.TreeNode;


/**
 * given in-order and pre-order of a binary tree
 * construct the tree
 */

/**
 * Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code) to pick next element in next recursive call
 *
 * Create a new tree node tNode with the data as picked element.
 *
 * Find the picked element’s index in Inorder. Let the index be inIndex.
 *
 * Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
 *
 * Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
 *
 * return tNode.
 *
 * =================================
 * let total nodes in tree = n
 *
 * TC = O(n)
 * SC = O(n)
 */


public class p2_tree_using_in_and_pre {

    public static void main(String[] args) {
        int[] in_order = {4, 2, 5, 1, 6, 3};
        int[] pre_order = {1, 2, 4, 5, 3, 6};

        TreeNode root = new p1_tree_using_in_and_post_soln().construct_tree(in_order, pre_order);
        root.print_in_order(root);
    }
}


class p2_tree_using_in_and_pre_soln {

    int PRE_IDX;

    TreeNode construct_tree(int[] in, int[] pre) {
        this.PRE_IDX = in.length - 1;
        return this.construct_tree_util(in, pre, 0, in.length - 1);

    }

    TreeNode construct_tree_util(int[] in, int[] pre, int in_start, int in_end) {

        if (in_start > in_end) {
            return null;
        }

        if (in_start == in_end) {
            return new TreeNode(pre[PRE_IDX++]);
        }


        int data = pre[PRE_IDX++];
        TreeNode root = new TreeNode(data);
        int index_in_inorder = find_in_inorder(in, data);


        root.left = construct_tree_util(in, pre, in_start, index_in_inorder - 1);
        root.right = construct_tree_util(in, pre, index_in_inorder + 1, in_end);
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

