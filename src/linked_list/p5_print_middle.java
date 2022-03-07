package linked_list;

import models.SLL;


/**
 *
 *
 * Given a linked list, print its middle node
 *
 */

/**
 *
 *
 * using slow and fast pointers
 *
 *
 * NOTE :
 * 1. length is even : fast.next = null      :
 * 2. length is odd  : fast = null :
 *
 * ==============
 * TC = O(n)
 * SC = O(1)
 *
 */

public class p5_print_middle {

    public static void main(String[] args) {

        //odd length loop , expected=3
        SLL head;
        head = new SLL(1);
        head.next = new SLL(2);
        head.next.next = new SLL(3);
        head.next.next.next = new SLL(4);
        head.next.next.next.next = new SLL(5);

        //even length loop : expected = 3
//        SLL head;
//        head = new SLL(1);
//        head.next = new SLL(2);
//        head.next.next = new SLL(3);
//        head.next.next.next = new SLL(4);
//        head.next.next.next.next = new SLL(5);
//        head.next.next.next.next.next = new SLL(6);

        p5_print_middle_soln.print(head);
    }
}


class p5_print_middle_soln {

    static void print(SLL head) {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            System.out.print(head.val);
            return;
        }

        helper(head, head.next);
    }


    private static void helper(SLL slow, SLL fast) {

        //if list is odd lengthed : fast=null
        //if list is even lengthed : fast.next=null
        if (fast == null || fast.next == null) {
            System.out.println(slow.val);
            return;
        }

        helper(slow.next, fast.next.next);
    }
}
