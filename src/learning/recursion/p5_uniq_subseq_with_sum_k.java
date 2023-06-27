package learning.recursion;
import  java.util.*;

/**
 *
 * lc : 40
 * 
 * https://leetcode.com/problems/combination-sum-ii/
 * 
 * given an array (with duplicates) , print all sub-seq with sum as k ,
 * an element can be picked atmost once
 *
 * NOTE : the should not be any duplicate sub-seq in the answer
 *
 */

public class p5_uniq_subseq_with_sum_k {

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,2,1,2};
        int k = 5;
        List<List<Integer>> ans =
                new p5_uniq_subseq_with_sum_k_soln().get(arr, k);


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



class p5_uniq_subseq_with_sum_k_soln {

    List<List<Integer>> ans;
    Set<String> known_set;


    List<List<Integer>> get(int[] arr, int k) {
        ans = new LinkedList<>();
        known_set = new HashSet<>();
        Arrays.sort(arr);

        //begin
        helper(arr, k, 0, 0, new LinkedList<>());
        return ans;
    }

    void helper(int[] arr, int k, int idx, int sum, List<Integer> ll) {

        //base case 1 : no more elements
        if(idx == arr.length){
            this.check(ll , k , sum);
            return;
        }


        //case-1 : pick
        ll.add(arr[idx]);
        helper(arr , k , idx+1 , sum+arr[idx] , ll);
        ll.remove(ll.size()-1);


        //case-2 : not-pick
        helper(arr , k , idx+1 , sum , ll);
    }

    void check(List<Integer> ll, int k, int sum) {
        if (sum != k) {
            return;
        }


        //check if this combintaion already exist
        String new_combintaion ="";
        for (Integer i : ll) {
            new_combintaion += i + "_";
        }

        if(known_set.contains(new_combintaion)){
            return;
        }

        //if combination does not exist , add to list and set
        LinkedList ll2 = new LinkedList();
        for (Integer i : ll) {
            ll2.add(i);
        }
        known_set.add(new_combintaion);
        ans.add(ll2);
    }

}
