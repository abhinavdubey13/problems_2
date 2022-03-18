package matrix;

import java.util.*;

/**
 *
 * input[i][j]=1 means i knows j (and not vice-versa)
 *
 * https://www.geeksforgeeks.org/the-celebrity-problem/
 */

/**
 *
 * ============
 * approach : 1
 * ============
 *
 * simple scan
 *
 * TC= O(N^2)
 * SC= O(1)
 *
 * ==============
 * approach : 2
 * ==============
 * using stack
 *
 * using the fact that
 * 1. arr[i][j]=1 => i cannot be celeb : BCZ CELEB KNOWS NONE
 * 2. arr[i][j]=0 => j cannot be celeb : BCZ CELEB IS KNOWN BY ALL
 *
 *
 * TC= O(N)
 * SC= O(N)
 *
 * https://www.youtube.com/watch?v=bSV4gyq2zyM&ab_channel=Logicmojo
 *
 */


public class p1_find_celebrity {

    public static void main(String[] args) {
        //id=2 is celeb
//         int arr[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

        //no celeb here
        int arr[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 1, 0, 0, 0 }, { 0, 0, 1, 0 } };

       System.out.println(p1_find_celebrity_soln.find(arr));
    }
}


class p1_find_celebrity_soln {

    static Integer find(int[][] arr) {

        Stack<Integer> my_stack = new Stack<>();

        for (int idx = 0; idx < arr.length; idx++) {
            my_stack.push(idx);
        }

        while (my_stack.size() > 1) {
            int i = my_stack.pop().intValue();
            int j = my_stack.pop().intValue();

            if (knows(arr, i, j)) {
                //if i knows j => i cannot be celeb : BCZ CELEB KNOWS NONE
                my_stack.push(j);
            } else {
                //if i does not know j => j cannot be celeb : BCZ CELEB IS KNOWN BY ALL
                my_stack.push(i);
            }
        }

        int potential_celeb_idx = my_stack.pop().intValue();

        if (final_check(arr, potential_celeb_idx)) {
           return potential_celeb_idx;
        } else {
            return null;
        }

    }

    //x knows y iff arr[x][y]=1
    private static boolean knows(int arr[][], int x, int y) {
        return (arr[x][y] == 1);
    }

    private static boolean final_check(int arr[][], int idx) {
        for (int i = 0; i < arr.length; i++) {

            int check_1 = arr[idx][i]; //if candidate knows some-one else
            int check_2 = arr[i][idx]; //if candidate is not known by some-one
            if (i != idx && (check_1 == 1 || check_2 == 0)) {
                return false;
            }
        }
        return true;
    }


}