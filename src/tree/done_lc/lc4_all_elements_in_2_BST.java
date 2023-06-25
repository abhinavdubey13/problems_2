package tree.done_lc;

import models.TreeNode;
import java.util.*;

/**
 *
 *
 * leetcode : 1305
 *
 *
 * Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.
 *
 *
 */

/**
 *
 * approach-1 : store inorder traversal in separate arrays , merge 2 sorted
 * arrays
 *
 *
 * approach-2 : iterative inorder traversal of 2 trees together
 *
 */

public class lc4_all_elements_in_2_BST {

    public static void main(String[] args) {
        TreeNode root1 = getTree1();
        TreeNode root2 = getTree2();

        List<Integer> sorted_list = lc4_all_elements_in_2_BST_soln.getAllElements(root1, root2);
        for (Integer i : sorted_list) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }

    static TreeNode getTree1() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        return root;
    }

    static TreeNode getTree2() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(11);
        return root;
    }
}

class lc4_all_elements_in_2_BST_soln {

    static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stk1 = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();

        List<Integer> res = new ArrayList<>();

        TreeNode ptr1 = root1;
        TreeNode ptr2 = root2;
        while (ptr1 != null || stk1.size() > 0 || ptr2 != null || stk2.size() > 0) {

            while (ptr1 != null) {
                stk1.push(ptr1);
                ptr1 = ptr1.left;
            }

            while (ptr2 != null) {
                stk2.push(ptr2);
                ptr2 = ptr2.left;
            }

            // condition to pick from stk2 : if stk1 is  empty || top(stk1) > top(stk2)
            if (stk1.isEmpty() || (stk2.size() > 0 && stk2.peek().val <= stk1.peek().val)) {
                ptr2 = stk2.pop();
                res.add(ptr2.val);
                ptr2 = ptr2.right;
            }

            else {
                ptr1 = stk1.pop();
                res.add(ptr1.val);
                ptr1 = ptr1.right;
            }
        }

        return res;
    }

}