package DP;


/**
 *
 * lc: 322
 *
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 */




/**
 *
 * x-axis = coins available
 * y-axis = SUM to be formed
 *
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom
 *
 * table[i][curr_sum] = min(#coins to form sum=curr_sum with current coin ,  #coins to form sum=curr_sum without current coin)
 *
 * #coins to form sum=curr_sum without current coin = table[i-1][curr_sum]
 * #coins to form sum=curr_sum with current coin = table[i][curr_sum-currentCoin]  => since infinte coins are available , we dont go to previous row
 *
 * TC = O(set-size . SUM)
 * SC = O(set-size . SUM)
 *
 *
 */


public class lc12_coin_change {

    public static void main(String[] args) {

        //ans=3
//        int sum = 11;
//        int[] coin_set = new int[] { 1,2,5 };

        //ans = -1
        int sum = 3;
        int[] coin_set = new int[] { 2};

        int answer = lc12_coin_change_soln.find(sum, coin_set);
        System.out.println(answer);

    }
}

class lc12_coin_change_soln {

    static int find(int sum , int[] coins){

        int[][] dp = new int[coins.length][sum+1];

        //1st row
        for(int i=1 ; i <= sum ; i++){
            if(i%coins[0]==0){
                dp[0][i] = 1+dp[0][i-coins[0]];
            }else{
                dp[0][i] = -1;
            }
        }

        for(int i=1 ; i< coins.length ; i++){
            for(int j=1 ; j<=sum ; j++){

                int curr_coin = coins[i];
                boolean includable = (curr_coin <= j && dp[i][j-curr_coin] > -1);

                if(includable){
                    int top = dp[i-1][j];
                    dp[i][j] = (top==-1)?1+dp[i][j-curr_coin] : Math.min(top , 1+dp[i][j-curr_coin]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        return dp[coins.length-1][sum];
    }
}



