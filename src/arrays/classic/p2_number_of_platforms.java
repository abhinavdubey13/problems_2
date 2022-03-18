package arrays.classic;


import java.util.*;

/**
 * https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 *
 * given arrival and departure times of N trains  , find minimum number of platforms needed so that no train waits
 *
 * arr[i] : arrival time of i'th train
 * dep[i] : departure time of the same (i'th) train
 *
 * ==========
 * example :
 * ==========
 */

/**
 * ==========
 * approach :
 * ===========
 * sort both : arrival[] and departure[]
 * use i : index pointer in arrival[] , initialize ar 1
 * use j : index pointer in departure[] , initialize at 0
 *
 * loop while(i and j < N)
 * - whenever we move j , we de-crement the number of platforms , bcz a train has departed ,
 * - whenever we move i , we in-crement the number of platforms , bcz train has arrived
 *
 * =======================================================
 * input array size = N
 *
 * TC = O(N.logN)
 * SC = O(1)
 *
 * =======================================================
 * brute force = O(N^2)
 */

public class p2_number_of_platforms {
    public static void main(String[] args) {
        //expected = 3
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};


        System.out.println(p2_number_of_platforms_soln.find(arr, dep));
    }

}


class p2_number_of_platforms_soln {

    static int find(int[] arrival, int[] dept) {
        Arrays.sort(arrival);
        Arrays.sort(dept);

        int answer = 1;
        int curr = 1;
        int i = 1;
        int j = 0;
        int n = arrival.length;

        while (i < n && j < n) {
            if (arrival[i] <= dept[j]) {
                i++;
                curr++;
            } else {
                j++;
                curr--;
                curr = Math.max(curr, 0);//curr cannot be negative
            }

            answer = Math.max(answer, curr);
        }


        return answer;
    }
}