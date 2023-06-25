package tree.classic_2;

import models.TreeNode;


/**
 * https://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
 *
 *
 * given a binary tree , find size of largest BST in it
 *
 * if no BST is there , then print 1 , bcz leaf node is always BST
 *
 *
 */


/**
 *
 * head recursion
 *
 * each node needs to tell its parent about some details
 *
 *
 */


class Detail {
    boolean isBST;
    int bstSize;
    int smallest;
    int largest;

    Detail(boolean is, int bs, int s, int l) {
        this.isBST = is;
        bstSize = bs;
        smallest = s;
        largest = l;
    }
}

public class p13_size_of_largest_bst {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(50);

        root.left = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(10);

        root.right = new TreeNode(60);
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(70);
        root.right.right.right = new TreeNode(80);
        root.right.right.left = new TreeNode(65);

        System.out.println(p13_size_of_largest_bst_soln.largest_bst(root));

    }
}


class p13_size_of_largest_bst_soln {

    static int largest_bst(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Detail d = helper(root);
        return d.bstSize;
    }


    static Detail helper(TreeNode curr) {

        //null node
        if (curr == null) {
            return new Detail(true,0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        //leaf node
        if (curr.left == null && curr.right == null) {
            return new Detail(true,1, curr.val, curr.val);
        }

        Detail ld = helper(curr.left);
        Detail rd = helper(curr.right);

        //if left and right are BST , then only curr node cud be BST
        if (ld.isBST && rd.isBST) {
            boolean isBstAtCurrNode = (curr.val > ld.largest && curr.val < rd.smallest);
            if (isBstAtCurrNode) {
                return new Detail(true,ld.bstSize + rd.bstSize + 1, ld.smallest, rd.largest);
            }
        }


        return new Detail(false , Math.max(ld.bstSize, rd.bstSize) , ld.smallest, rd.largest);
    }

}