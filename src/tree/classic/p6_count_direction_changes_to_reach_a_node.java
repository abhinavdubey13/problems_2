package tree.classic;


import models.TreeNode;

/**
 *
 * given a binary tree , we have to find the number of direction changes required to get to a target-node from source-node
 *
 * note : target-node must be in the LST or RST of source-node
 *
 */


/**
 *
 *
 * using recursion
 *
 * =================================
 * let total nodes in trees = n , m
 *
 * TC = O(n)
 * SC = O(ht)
 *
 */



public class p6_count_direction_changes_to_reach_a_node {

    public static void main(String[] args) {

        //left tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);

        TreeNode target= root.right.left.right;



        System.out.println(p6_count_direction_changes_to_reach_a_node_soln.find(root, target));
    }
}



class p6_count_direction_changes_to_reach_a_node_soln {


    static int find(TreeNode root , TreeNode target){
        if(root==null || target==null){
            return -1;
        }

        int l =  helper(root.left , target , "left" , 0);
        int r =  helper(root.right , target , "right" , 0);

        if(l==-1 && r==-1){
            System.out.println("target not found in tree");
            return -1;
        }else if(l==-1){
            return r;
        }else{
            return l;
        }



    }


    static int helper(TreeNode curr , TreeNode target , String curr_direction , int curr_direction_changes){

        if(curr==null){
            return -1;
        }

        if(curr==target){
            return curr_direction_changes;
        }


        int l=-1 , r=-1;

        if(curr_direction == "left"){
            l = helper(curr.left , target , "left" , curr_direction_changes);
            r = helper(curr.right , target , "right" , curr_direction_changes+1);
        }else if(curr_direction == "right"){
            l = helper(curr.left , target , "left" , curr_direction_changes+1);
            r = helper(curr.right , target , "right" , curr_direction_changes);
        }


        if(l==-1 && r==-1){
            return -1;
        }else if(l==-1){
            return r;
        }else{
            return l;
        }




    }
}
