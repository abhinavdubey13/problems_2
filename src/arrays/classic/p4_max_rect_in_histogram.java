package arrays.classic;

import java.util.*;

public class p4_max_rect_in_histogram {

    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(p4_max_rect_in_histogram_soln.find(arr));
    }
}


class p4_max_rect_in_histogram_soln {

    static int find(int[] arr) {
        Stack<Integer> stk = new Stack<>();


        int answer = -1;
        int i=0;
        while (i < arr.length) {
            int curr = arr[i];
            if (stk.isEmpty() || arr[stk.peek()] <= curr) {
                stk.push(i);
                i++;
            } else {
                int popped = stk.pop();
                int height = arr[popped];
                int width = (stk.isEmpty()) ? i : i - stk.peek() - 1;
                answer = Math.max(answer,  height * width);
            }
        }


        while(stk.size() > 0){
            int popped = stk.pop();
            int height = arr[popped];
            int width = (stk.isEmpty()) ? i : i - stk.peek() - 1;
            answer = Math.max(answer,  height * width);
        }

        return answer;
    }
}

