package POC.recursion;

import java.util.*;

/**
 *
 * print all subseq whose sum is K
 *
 * an element from the given array can be picked any number of times
 *
 */


public class p4_combintaion_sum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3 , 5};
        int k = 8;
        List<List<Integer>> ans =
                new p4_combintaion_sum_soln().get(arr, k);


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

        //base case 1 : sum over-flow
        if(sum > k){
            return;
        }

        //base case 2 : no more elements
        if(idx == arr.length){
            this.check(ll , k , sum);
            return;
        }


        //case-1 : pick
        //since we can pick an element any number of times , the "idx" is same
        ll.add(arr[idx]);
        helper(arr , k , idx , sum+arr[idx] , ll);
        ll.remove(ll.size()-1);


        //case-2 : not-pick
        helper(arr , k , idx+1 , sum , ll);
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
