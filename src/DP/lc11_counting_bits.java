package DP;


/**
 *
 * LC : 338
 *
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
 *
 * ans[i] is the number of 1's in the binary representation of i.
 *
 *
 */

public class lc11_counting_bits {

    public static void main(String[] args) {

        int n = 16;
        int[] ans = new lc11_counting_bits_soln().countBits(n);

        for(int i=0;i<ans.length ; i++){
            System.out.println(i + "-->" + ans[i]);
        }
    }
}




class lc11_counting_bits_soln {

    public int[] countBits(int n) {

        int[] res = new int[n+1];

        res[0]=0;
        if(n==0){
            return res;
        }

        res[1]=1;
        if(n==1){
            return res;
        }


        res[2]=1;
        if(n==2){
            return res;
        }

        for(int i=3;i<=n ; i++){
            if(i%2==1){
                res[i] = res[i-1]+1;
            }else{
                res[i] = res[i/2];
            }
        }





        return res;

    }


}
