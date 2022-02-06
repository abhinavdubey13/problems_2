package models;


@SuppressWarnings("unused")
public class TreeNode {
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


    public void print_in_order(TreeNode root){
        if (root != null) {
            print_in_order(root.left);
            System.out.print(root.val + " ");
            print_in_order(root.right);
        }
    }


}