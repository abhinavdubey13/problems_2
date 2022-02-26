package DP.classic;


/**
 *
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 *
 *
 *
 * Given weights and profits of N items, put these items in a knapsack of capacity W to get the maximum total profit in the knapsack.
 * Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that
 *
 * sum of the weights of this subset is smaller than or equal to W.
 *
 * NOTE : You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 *
 *
 *
 */

/**
 * ==========
 * APPROACH :
 * ==========
 *
 * x-axis = weigthts(and corresponding profit) given as input parameter
 * y-axis = total weight of knapsack considered
 *
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom
 *
 *
 * table[i][currentWeight] => MAX(profit with current i'th element , profit without i'th element)
 *
 *     profit without current i'th element => table[i-1][currentWeight] => the element just above
 *     profit with current i'th element => table[i-1][currentWeight-weight of i'th element]
 *
 * =======================
 * total items = n
 * knapSack capacity = W
 *
 * TC = O(n.W)
 * SC = O(n.W)
 *
 *
 */



public class p1_01_knapsack {

    public static void main(String[] args) {

        //expected : 220
        int[] profits = new int[] { 60, 100, 120 };
        int[] weights = new int[] { 10, 20, 30 };
        int capacity = 50;

        int ans = p1_01_knapsack_soln.findMaxProfit(capacity, weights, profits);
        System.out.println(ans);
    }

}




class p1_01_knapsack_soln {

    static int findMaxProfit(int capacity , int[] weights , int[]profits){

        //if no capacity or no wights
        if(capacity <1 || weights.length <1){
            return 0;
        }

        int n = weights.length;
        int[][] dp = new int[n][capacity+1];

        //1st column , capacity=0
        for(int i=0;i<n ; i++){
            dp[i][0]=0;
        }

        //1st row , considering only 1 items
        //i denotes capacity here
        for(int i=0;i<n ; i++){
            dp[0][i]= (weights[i] <= i) ? profits[i] : 0;
        }


        for(int i=1 ; i<n ;i++){
            for(int j=1 ; j<=capacity ;j++){
                int if_curr_item_included = (weights[i] <= j)? profits[i] + dp[i-1][j-weights[i]]:0;
                int if_curr_item_excluded = dp[i-1][j];
                dp[i][j] = Math.max(if_curr_item_excluded , if_curr_item_included);
            }
        }

        return dp[n-1][capacity];
    }
}
