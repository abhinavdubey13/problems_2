package DP;

/**
 *
 * lc:70
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 *
 */


/**
 *
 * similar to fibonacci
 *
 *
 */

public class lc14_climbing_stairs {

    public static void main(String[] args) {
       int n = 4;
       int ans = lc14_climbing_stairs_soln.find(n);
       System.out.println(ans);
    }

}


class lc14_climbing_stairs_soln{

    static int find(int n) {

        if(n<3){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }


}
