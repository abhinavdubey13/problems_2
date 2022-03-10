package linked_list;

import models.SLL;


/**
 * leetcode id :
 *
 * Given a linked list, the task is to find the length of the longest palindrome list in it
 * ========
 * example
 * ========
 *
 * i/p : 2-3-7-3-2-12-24
 * o/p : 5
 *
 *
 * longest palindrome is : (2-3-7-3-2)
 *
 *
 */

/**
 *
 *
 * ============
 * approach : 1
 * ============
 * based on the reversing of linked list
 *
 * continue reversing the entire list normally ,
 * in between , check for the longest palindromes (odd and even length)
 *
 * using reversed and un-reversed linked list as the 2 lists
 *
 *
 * ==========
 * TC = O(n^2)
 * SC = O(1)
 *
 *
 *
 */


public class p8_longest_palindrome_in_ll {

    public static void main(String[] args) {


//        //expected : 6
//        SLL head = new SLL(1);
//        head.next = new SLL(2);
//        head.next.next = new SLL(3);
//        head.next.next.next = new SLL(3);
//        head.next.next.next.next = new SLL(2);
//        head.next.next.next.next.next = new SLL(1);

        //expected : 4
        SLL head = new SLL(1);
        head.next = new SLL(2);
        head.next.next = new SLL(2);
        head.next.next.next = new SLL(1);
        head.next.next.next.next = new SLL(2);
        head.next.next.next.next.next = new SLL(1);

        int answer = new p8_longest_palindrome_in_ll_soln().find(head);
        System.out.println(answer);
    }

}


class p8_longest_palindrome_in_ll_soln {

    private int ANSWER;

    int find(SLL head) {
        reverse(head);
        return this.ANSWER;
    }


    private void reverse(SLL head) {

        if (head == null || head.next == null) {
            this.ANSWER = (head == null) ? 0 : 1;
            return;
        }

        SLL nxt = null;
        SLL prv = null;
        SLL curr = head;

        while (curr != null) {
            nxt = curr.next;
            curr.next = prv;


            //here check for odd and even length palins
            check_curr_palin_length(curr, nxt, "even");
            if (nxt != null && nxt.next != null)
                check_curr_palin_length(curr, nxt.next, "odd");

            prv = curr;
            curr = nxt;
        }

    }


    private void check_curr_palin_length(SLL a, SLL b, String type) {

        int curr_max = 0;

        while (a != null && b != null) {
            if (a.val == b.val) {
                curr_max++;
                a = a.next;
                b = b.next;
            } else {
                break;
            }
        }

        if (type == "odd") {
            curr_max = 2 * curr_max + 1;
        } else if (type == "even") {
            curr_max = 2 * curr_max;
        }
        this.ANSWER = Math.max(this.ANSWER, curr_max);
    }


}

