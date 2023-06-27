package learning.recursion;

import java.util.*;

/**
 *
 * learning recursion
 *
 * https://www.youtube.com/watch?v=AxNNVECce8c&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=7&ab_channel=takeUforward
 *
 *
 * printing all sub-sequences of an array
 *
 */

public class p1_all_subsequence {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3 };
        new p1_all_subsequence_soln().print(arr);

    }
}


class p1_all_subsequence_soln {

    void print(int[] arr) {
        List<Integer> curr = new LinkedList<>();
        helper(arr, 0, curr);
    }

    void helper(int[] arr, int idx, List<Integer> curr) {
        if (idx >= arr.length) {
            printList(curr);
            return;
        }

        // case-1 : pick
        curr.add(arr[idx]);
        helper(arr, idx + 1, curr);
        curr.remove(curr.size() - 1);

        // case-2 : not pick
        helper(arr, idx + 1, curr);
    }

    void printList(List<Integer> curr) {
        if (curr.size() == 0) {
            System.out.println("{}");
        }
        for (Integer i : curr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}