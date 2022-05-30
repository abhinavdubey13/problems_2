package POC.recursion;

import java.util.*;


/**
 *
 * count all subseq whose sum is K
 *
 */



public class p3_count_subseq_with_sum_as_k {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1};
        int k = 4;
        System.out.println(new p3_count_subseq_with_sum_as_k_soln().getCount(arr,k));
    }
}



class p3_count_subseq_with_sum_as_k_soln {


    int getCount(int[] arr , int k){
        int ans = helper(arr , 0 , k , 0);
        return ans;
    }


    int helper(int[] arr , int idx , int k ,int curr_sum){
        if(idx == arr.length){
            int add = this.check(k , curr_sum );
            return add;
        }

        //case-1 : pick
        int p1 = helper(arr , idx+1 , k , curr_sum+arr[idx]);

        //case-2 : not-pick
        int p2 = helper(arr , idx+1 , k , curr_sum);
        return p1+p2;
    }


    int check(int k , int curr_sum){
        if(curr_sum != k){
            return 0;
        }
        return 1;
    }

}
