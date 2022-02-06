package math;




/**
 * GCD : greatest common divisor
 *
 * GCD(15,10) = 5
 * GCD(9,9) = 9
 * GCD(2,0) = 2
 *
 * here we have used euclidean theorem to find GCD
 *
 */


public class lc1_GCD_of_2_numbers {

    public static void main(String[] args) {

        System.out.println(new lc1_GCD_of_2_numbers_soln().function(15, 10));
        System.out.println(new lc1_GCD_of_2_numbers_soln().function(10, 0));
        System.out.println(new lc1_GCD_of_2_numbers_soln().function(5, 5));


    }
}

class lc1_GCD_of_2_numbers_soln {

    int function(int larger, int smaller) {
        if (smaller == 0) {
            return larger;
        }
        return function(smaller, larger % smaller);
    }
}
