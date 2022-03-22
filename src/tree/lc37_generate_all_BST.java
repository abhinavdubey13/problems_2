package tree;

import models.TreeNode;
import java.util.*;

/**
 * leetcode id : 95
 *
 * Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 *
 *
 */


/**
 *
 *
 * ============
 * approach :
 * ============
 *
 * start by noting that 1..n is the in-order traversal for any BST with nodes 1 to n
 *
 * So if we pick i-th node as my root, the left subtree will contain elements 1 to (i-1), and the right subtree will contain elements (i+1) to n
 *
 * Then use recursive calls to get back all possible trees for left and right subtrees and combine them in all possible ways with the root
 *
 * ===========
 * TC=O()
 * SC=O()
 *
 *
 *
 */


public class lc37_generate_all_BST {
}


class lc37_generate_all_BST_soln {

    List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {

        List<TreeNode> list = new ArrayList<TreeNode>();

        if (start > end) {
            list.add(null);
            return list;
        }

        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {

            left = helper(start, i - 1);
            right = helper(i + 1, end);

            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }

        }

        return list;
    }
}