package learning.recursion;

/**
 * 
 * basic question :
 * -print 1 to n using recursion & back-tracking
 * -sum of 1st n numbers
 * 
 * https://www.youtube.com/watch?v=un6PLygfXrA&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=2&ab_channel=takeUforward
 * 
 */
public class p0_basics {

    public static void main(String[] args) {

        int n = 5;
        new Print_1_to_n_using_recursion().solve(n, 1);
        new Print_1_to_n_using_recursion_backtracking().solve(n, 1);
        System.out.println(new Sum_1st_n_numbers_using_functional_recursion().solve(n));
        System.out.println(new Sum_1st_n_numbers_using_parameterized_recursion().solve(n, 0));

        // reverse array using recursion
        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        new Reverse_array_using_recursion().solve(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }

        // print nth fibonacci number
        System.out.println();
        System.out.println(new Nth_fibonacci_number().solve(n));

    }

}

class Print_1_to_n_using_recursion {
    void solve(int n, int curr) {
        if (curr > n) {
            System.out.println();
            return;
        }
        System.out.print(curr + " ");
        solve(n, curr + 1);
    }
}

class Print_1_to_n_using_recursion_backtracking {
    void solve(int n, int curr) {
        if (curr > n) {
            System.out.println();
            return;
        }
        solve(n, curr + 1);
        System.out.print(curr + " ");
    }
}

class Sum_1st_n_numbers_using_functional_recursion {
    int solve(int n) {
        if (n <= 0) {
            System.out.println();
            return 0;
        }
        return n + solve(n - 1);
    }
}

class Sum_1st_n_numbers_using_parameterized_recursion {
    int solve(int n, int sum_till_now) {
        if (n <= 0) {
            return sum_till_now;
        }
        return solve(n - 1, n + sum_till_now);
    }
}

class Reverse_array_using_recursion {
    void solve(int[] arr) {
        helper(arr, 0, arr.length - 1);
    }

    private void helper(int[] arr, int i, int j) {
        if (i >= j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        helper(arr, i + 1, j - 1);
    }
}

class Nth_fibonacci_number {

    // fib(n) = fib(n-1)+ fib(n-2)
    int solve(int n) {
        if (n <= 1) {
            return n;
        }

        return solve(n - 1) + solve(n - 2);
    }

}