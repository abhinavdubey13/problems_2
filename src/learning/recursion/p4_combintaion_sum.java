package learning.recursion;

import java.util.*;

/**
 *
 * lc : 39
 * 
 * https://leetcode.com/problems/combination-sum/
 * 
 * print all subseq whose sum is K
 *
 * an element from the given array can be picked any number of times
 *
 */

public class p4_combintaion_sum {
    public static void main(String[] args) {

        // int[] arr = new int[] { 2, 3, 5 };
        // int k = 8;

        int[] arr = new int[] { 7, 3, 2 };
        int k = 18;

        // List<List<Integer>> ans = new p4_combintaion_sum_soln().get(arr, k);
        List<List<Integer>> ans = new p4_combintaion_sum_soln_rev1().get(arr, k);

        printList(ans);
    }

    static void printList(List<List<Integer>> ans) {
        for (List<Integer> l : ans) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}

class p4_combintaion_sum_soln {

    List<List<Integer>> ans;

    List<List<Integer>> get(int[] arr, int k) {
        ans = new LinkedList<>();
        helper(arr, k, 0, 0, new LinkedList<>());
        return ans;
    }

    void helper(int[] arr, int k, int idx, int sum, List<Integer> ll) {

        // base case 1 : sum over-flow
        if (sum > k) {
            return;
        }

        // base case 2 : no more elements
        if (idx == arr.length) {
            this.check(ll, k, sum);
            return;
        }

        // case-1 : pick
        // since we can pick an element any number of times , the "idx" is same
        ll.add(arr[idx]);
        helper(arr, k, idx, sum + arr[idx], ll);
        ll.remove(ll.size() - 1);

        // case-2 : not-pick
        helper(arr, k, idx + 1, sum, ll);
    }

    void check(List<Integer> ll, int k, int sum) {
        if (sum != k) {
            return;
        }
        LinkedList ll2 = new LinkedList();
        for (Integer i : ll) {
            ll2.add(i);
        }
        ans.add(ll2);
    }
}

class p4_combintaion_sum_soln_rev1 {

    List<Integer> sub_seq;
    List<List<Integer>> ans;
    Set<String> hset;

    public List<List<Integer>> get(int[] arr, int k) {
        hset = new HashSet<>();
        sub_seq = new LinkedList<>();
        ans = new LinkedList<>();
        helper(arr, 0, k, 0);
        return ans;
    }

    void helper(int[] arr, int i, int k, int sum_till_now) {
        // base case 1
        if (sum_till_now > k) {
            return;
        }

        // base case 2
        else if (i >= arr.length) {
            check(arr, k, sum_till_now);
            return;
        }

        // not pick : move ahead
        helper(arr, i + 1, k, sum_till_now);

        // pick + stay on same idx
        sub_seq.add(arr[i]);
        helper(arr, i, k, sum_till_now + arr[i]);
        sub_seq.remove(sub_seq.size() - 1);

        // pick and move ahead
        sub_seq.add(arr[i]);
        helper(arr, i + 1, k, sum_till_now + arr[i]);
        sub_seq.remove(sub_seq.size() - 1);
    }

    void check(int[] arr, int k, int sum_till_now) {
        if (sum_till_now != k) {
            return;
        }
        List<Integer> t1 = new LinkedList<>();
        List<Integer> t2 = new LinkedList<>();
        for (Integer i : sub_seq) {
            t1.add(i);
            t2.add(i);
        }

        Collections.sort(t1);
        String str = "";
        for (Integer i : t1) {
            str += String.valueOf(i);
        }

        if (hset.contains(str)) {
            return;
        }

        ans.add(t2);
        hset.add(str);
    }
}
