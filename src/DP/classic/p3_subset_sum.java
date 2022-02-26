package DP.classic;

public class p3_subset_sum {

    public static void main(String[] args) {

        //false
         int sum = 30;
         int[] setToConsider = new int[] { 3, 34, 4, 12, 5, 2 };

        //true
//        int sum = 15;
//        int[] setToConsider = new int[] { 1, 3, 4, 11 };

        boolean answer = p3_subset_sum_soln.find(sum, setToConsider);
        System.out.println(answer);

    }
}




class p3_subset_sum_soln {

    static boolean find(int sum , int[] items){

        boolean[][]dp = new boolean[items.length][sum+1];

        //sum=0 is always possible , so fill 1st column
        for(int i=0;i< items.length;i++){
            dp[i][0] = true;
        }


        //fill 1st row , true only if item[i]=i
        for(int i = 1; i <= sum ; i++){
            dp[0][i] = (items[0] == i) ? true:false;
        }


        for(int i = 1; i < items.length ; i++){
            for(int j=1 ; j<= sum ; j++){

                boolean incl = (items[i] <= j)? dp[i-1][j-items[i]] : false;
                boolean excl = dp[i-1][j];

                dp[i][j] = incl || excl;
            }
        }


        return dp[items.length-1][sum];
    }
}
