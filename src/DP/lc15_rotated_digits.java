package DP;
import java.util.*;

/**
 *
 * lc : 788
 *
 *
 *
 * An integer x is a good if after rotating each digit individually by 180 degrees, we get a valid number that is different from x. Each digit must be rotated - we cannot choose to leave it alone.
 *
 * A number is valid if each digit remains a digit after rotation. For example:
 *
 * 0, 1, and 8 rotate to themselves,
 * 2 and 5 rotate to each other (in this case they are rotated in a different direction, in other words, 2 or 5 gets mirrored),
 * 6 and 9 rotate to each other,
 *
 * the rest of the numbers do not rotate to any other number and become invalid.
 * Given an integer n, return the number of good integers in the range [1, n].
 *
 *
 */


/**
 *
 *
 * a number is good iff
 *
 * 1. it does not contain invalid numbers(3,4,7)
 * 2. it has atleast 1 of (2,5,6,9) , so that rotated number is diff. from original number
 *
 */


public class lc15_rotated_digits {
    public static void main(String[] args) {
        int n = 50;
        int ans = lc15_rotated_digits_soln.find(n);
        System.out.println("count : " + ans);
    }
}



class lc15_rotated_digits_soln {

    static int find(int n) {
        Set<Integer>invalids = new HashSet<>(Arrays.asList(3,4,7));
        Set<Integer>self = new HashSet<>(Arrays.asList(0,1,8));
        Set<Integer>valids = new HashSet<>(Arrays.asList(2,5,6,9));

        int good=0;
        for(int i=1;i<=n;i++){
            int j=i;
            boolean has_invalids = false;
            boolean has_valids = false;

            while(j>0){
                int rem = j%10;
                if(invalids.contains(rem)){
                    has_invalids=true;
                    break;
                }else if(valids.contains(rem)){
                    has_valids=true;
                }
                j=j/10;
            }

            if(!has_invalids && has_valids){
                System.out.println("good : " + i);
                good++;
            }
        }

        return good;
    }
}
