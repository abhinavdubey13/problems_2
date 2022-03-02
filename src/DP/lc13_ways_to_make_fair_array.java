package DP;

/**
 *
 * lc : 1664
 *
 *
 * You are given an integer array nums. You can choose exactly one index (0-indexed) and remove the element. Notice that the index of the elements may change after the removal.
 *
 * For example, if nums = [6,1,7,4,1]:
 *
 * Choosing to remove index 1 results in nums = [6,7,4,1].
 * Choosing to remove index 2 results in nums = [6,1,4,1].
 * Choosing to remove index 4 results in nums = [6,1,7,4].
 * An array is fair if the sum of the odd-indexed values equals the sum of the even-indexed values.
 *
 * Return the number of indices that you could choose such that after the removal, nums is fair.
 *
 *
 *
 * Input: nums = [2,1,6,4]
 * Output: 1
 *
 *
 *
 *
 */


/**
 *
 * https://medium.com/swlh/ways-to-make-a-fair-array-algorithms-visualizations-a2ae3c9d881e
 *
 */

public class lc13_ways_to_make_fair_array {

    public static void main(String[] args) {

        //expected=4
        int[] arr={1,1,1};
        int answer = lc13_ways_to_make_fair_array_soln.find(arr);
        System.out.println(answer);

    }
}



class lc13_ways_to_make_fair_array_soln {


    static int find(int[] arr) {
        int n = arr.length;

        //if only 1 element , remove it , summ(odd)=sum(even)=0
        if(n==1){
            return 1;
        }

        //if only 2 elements , we cannot equalize sum att odd n even indixes
        if(n==2){
            return 0;
        }

        int[] odd_b4 = new int[n];
        int[] odd_after = new int[n];
        int[] even_b4 = new int[n];
        int[] even_after = new int[n];

        //odd_b4
        for (int i=1;i<n;i++){
            if(i%2==0){
                odd_b4[i] = arr[i-1] + odd_b4[i-1];
            }else{
                odd_b4[i] = odd_b4[i-1];
            }
        }

        //odd-after
        for (int i=n-1;i>=0;i--){
            if(i+1 >= n){
                continue;
            }
            if(i%2==0){
                odd_after[i] = arr[i+1] + odd_after[i+1];
            }else{
                odd_after[i] = odd_after[i+1];
            }
        }

        //even-b4
        for (int i=1;i<n;i++){
            if(i%2==1){
                even_b4[i] = arr[i-1] + even_b4[i-1];
            }else{
                even_b4[i] = even_b4[i-1];
            }
        }

        //even-after
        for (int i=n-1;i>=0 ;i--){
            if(i+1 >= n){
                continue;
            }
            if( i%2==1){
                even_after[i] = arr[i+1] + even_after[i+1];
            }else{
                even_after[i] = even_after[i+1];
            }
        }

        int ways=0;
        for(int i=0;i<n;i++){
            if(odd_b4[i] + even_after[i] == odd_after[i] + even_b4[i]){
                ways++;
            }
        }

        return ways;
    }
}
