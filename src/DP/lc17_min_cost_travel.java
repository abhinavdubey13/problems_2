package DP;

import java.util.*;


/**
 * lc : 983
 *
 * In a country popular for train travel, you have planned some train travelling one year in advance.
 * The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
 *
 * Train tickets are sold in 3 different ways:
 *
 * a 1-day pass is sold for costs[0] dollars
 *
 * a 7-day pass is sold for costs[1] dollars;
 *
 * a 30-day pass is sold for costs[2] dollars.
 *
 * The passes allow that many days of consecutive travel.
 *
 * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
 *
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 *
 *
 * ==========
 * example :
 * ==========
 *
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 *
 * Explanation:
 *
 * For example, here is one way to buy passes that lets you travel your travel plan:
 *
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 *
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 *
 * In total you spent $11 and covered all the days of your travel.
 *
 *
 *
 * ========
 * NOTE :
 * ========
 *
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days is in strictly increasing order.
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 */


/**
 * ==========
 * APPROACH :
 * ==========
 *
 * same as p31_max_cuts
 *
 * we maintain table[365] , table[i]=>min cost to travel on ith day
 *
 *
 * IMPORTANT : if i is non-travel day , cost is same as previous day
 *
 * if i is travel day
 * we try 3 possibilitie : subtract 1,7,30 from current day
 *
 *
 *
 *
 *
 * TC = O(n)
 * SC = O(365)
 */

public class lc17_min_cost_travel {

    public static void main(String[] args) {

        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] cost = {2, 7, 15};
        int answer = lc17_min_cost_travel_soln.find(days, cost);
        System.out.println(answer);

    }

}

class lc17_min_cost_travel_soln {

    static int find(int[] days, int[] cost) {

        Set<Integer> hset = new HashSet<>();

        // add to hashset
        for (int day : days) {
            hset.add(day);
        }

        int[] table = new int[366];
        table[0] = 0;


        for (int i = 1; i <= 365; i++) {
            table[i] = Integer.MAX_VALUE;
            if (hset.contains(i)) {
                int case_1 = table[Math.max(0, i - 1)] + cost[0];
                int case_7 = table[Math.max(0, i - 7)] + cost[1];
                int case_30 = table[Math.max(0, i - 30)] + cost[2];
                table[i] = Math.min(Math.min(case_1, case_7), Math.min(case_30, table[i]));
            } else {
                table[i] = table[i - 1];
            }
        }

        return table[365];
    }

}