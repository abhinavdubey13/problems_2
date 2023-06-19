package tree;

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
}

class lc4_all_elements_in_2_BST_soln {

    List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
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
                stk1.push(ptr2);
                ptr2 = ptr2.left;
            }

            // condition to pick from stk2
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

class soln_22 {
    List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> answer = new LinkedList<>();

        Stack<TreeNode> stk1 = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();

        TreeNode ptr1 = root1;
        TreeNode ptr2 = root2;
        int min_val = 10000000;

        while (true) {
            if (ptr1 != null) {
                stk1.push(ptr1);
                ptr1 = ptr1.left;
            } else {
                if (stk1.size() == 0) {
                    if (stk2.size() == 0) {
                        break;
                    }
                    ptr1 = stk1.pop();
                    min_val = Math.min(ptr1.val, (ptr2 == null) ? Integer.MAX_VALUE : ptr2.val); 
                    answer.add(min_val);               
                    ptr1 = ptr1.right;
                }
            }

            if (ptr2 != null) {
                stk2.push(ptr2);
                ptr2 = ptr2.left;
            } else {
                if (stk2.size() == 0) {
                    if (stk1.size() == 0) {
                        break;
                    }
                    ptr2 = stk2.pop();
                    min_val = Math.min(ptr1.val, (ptr2 == null) ? Integer.MAX_VALUE : ptr2.val);
                    answer.add(min_val);               
                    ptr2 = ptr2.right;
                }
            }
        }

        return answer;
    }
}