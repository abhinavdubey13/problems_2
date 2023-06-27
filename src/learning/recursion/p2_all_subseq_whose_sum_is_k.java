package learning.recursion;
import java.util.*;


/**
 *
 * print all subseq whose sum is K
 *
 * an element from the given array can be picked atmost once
 *
 */





public class p2_all_subseq_whose_sum_is_k {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1 , 2};
        int k = 2;
        new p2_all_subseq_whose_sum_is_k_soln().print(arr,k);
    }
}




class p2_all_subseq_whose_sum_is_k_soln {


    void print(int[] arr , int k){
        List<Integer> sub_seq = new LinkedList<>();
        helper(arr , 0 , sub_seq , k , 0);
    }


    void helper(int[] arr , int idx , List<Integer> sub_seq , int k ,int curr_sum){
        if(idx == arr.length){
            this.printList(sub_seq , k , curr_sum );
            return;
        }

        //case-1 : pick
        sub_seq.add(arr[idx]);
        helper(arr , idx+1 , sub_seq , k , curr_sum+arr[idx]);
        sub_seq.remove(sub_seq.size()-1);

        //case-2 : not pick
        helper(arr , idx+1 , sub_seq , k , curr_sum);
    }


    void printList(List<Integer> sub_seq  , int k , int curr_sum){
        if(curr_sum != k){
            return;
        }
        for(Integer i : sub_seq){
            System.out.print(i + " ");
        }
        System.out.println();
    }

}