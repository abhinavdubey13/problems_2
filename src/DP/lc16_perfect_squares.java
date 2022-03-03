package DP;

/**
 *
 * lc: 279
 *
 *
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 *
 *
 */


/**
 *
 *
 * for each i , try subtracting perfect squares from i
 *
 *
 */

public class lc16_perfect_squares {

    public static void main(String[] args) {
        int n = 12;
        int answer = lc16_perfect_squares_soln.find(n);
        System.out.println(answer);
    }
}



class lc16_perfect_squares_soln {

    static int find(int n){
        if(n==1){
            return 1;
        }


        int[]dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3 ; i<=n; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=1 ; j*j <= i ; j++){
                dp[i] = Math.min(dp[i] , 1+dp[i-i*j]);
            }
        }

        return dp[n];
    }
}
