package backtracking;

/**
 *
 * lc : 698
 *
 *
 * Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,3,5,2,1], k = 4
 * Output: true
 * Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * Example 2:
 *
 * Input: nums = [1,2,3,4], k = 3
 * Output: false
 *
 *
 *
 *
 */

/**
 *
 *
 * 1st check if sum is divisible by K or not
 *
 * if yes , check all possible combinations
 *
 *
 *
 *
 */

public class lc4_check_k_equal_sum_partition {


    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int K = 4;

//        int[] nums = {1,1,2};
//        int K = 2;
        boolean answer = lc4_check_k_equal_sum_partition_soln.find(nums, K);
        System.out.println(answer);
    }
}


class lc4_check_k_equal_sum_partition_soln {


    static boolean find(int[] arr, int number_of_sets) {

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        if (sum % number_of_sets != 0) {
            return false;
        }

        int req_sum_of_each_set = sum / number_of_sets;
        boolean[] visited = new boolean[arr.length];

        boolean ans = helper(0, number_of_sets, 0, req_sum_of_each_set, arr, visited);
        return ans;
    }


    static boolean helper(int curr_set_sum, int sets_left, int idx, int req_sum_of_each_set, int[] arr, boolean[] vis) {

        if (sets_left == 0) {
            return true;
        }

        if (curr_set_sum == req_sum_of_each_set) {
            return helper(0, sets_left - 1, idx, req_sum_of_each_set, arr, vis);
        }

        for (int i = idx; i < arr.length; i++) {
            if (!vis[idx] && arr[i] + curr_set_sum <= req_sum_of_each_set) {
                vis[i] = true;
                boolean satisfied = helper(arr[i] + curr_set_sum, sets_left, idx + 1, req_sum_of_each_set, arr, vis);
                if (satisfied) {
                    return true;
                }
                vis[i] = false;
            }
        }


        return false;
    }

}