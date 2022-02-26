package DP.classic;


/**
 *
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 *
 *
 * Given two sequences, find the length of longest subsequence present in both of them.
 *
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 *
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 */


/**
 * ==========
 * APPROACH :
 * ==========
 *
 * x-axis : string 1 (length = s1)
 * y-axis : string 2 (length = s2)
 *
 * dp-array = 2D
 * array-filling = left-to-right , top-to-bottom
 *
 * table[i][j] => 1+table[i-1][j-1]                      if string1[i]==string2[j]
 *             => MAX( table[i-1][j] , table[i][j-1])     if no match
 *
 * ======================
 * TC = O(s1.s2)
 * SC = O(s1.s2)
 *
 */

public class p2_Longest_common_SubSeq {

    public static void main(String[] args) {


        //expected : 4
        String str1= "AGGTAB";
        String str2= "GXTXAYB";
        int answer = p2_Longest_common_SubSeq_soln.find(str1.toCharArray(), str2.toCharArray());
        System.out.println(answer);

    }
}



class p2_Longest_common_SubSeq_soln {

    static int find(char[] str1 , char[]str2){

        int[][]dp = new int[str1.length+1][str2.length+1];

        for(int i =1 ; i<= str1.length;i++){
            for(int j=1 ; j<= str2.length ; j++){

                int above= dp[i-1][j];
                int left = dp[i][j-1];
                int if_match = (str1[i-1]==str2[j-1])? 1 + dp[i-1][j-1] : 0;

                int max =  Math.max(if_match , Math.max(above,left));
                dp[i][j] = max;
            }
        }


        return dp[str1.length][str2.length];
    }
}
