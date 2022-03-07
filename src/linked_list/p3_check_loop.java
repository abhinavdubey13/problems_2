package linked_list;

import models.SLL;


/**
 *
 * Given a linked list, check if the linked list has loop or not. Below diagram shows a linked list with a loop.
 *
 *
 */

/**
 *
 *
 * ============
 * approach : 1
 * ============
 * maitain a set of addresses of nodes , if while traversing the list , we get repeated address , it has a loop
 * if iterator becomes null , no loop found
 *
 * ==============
 * TC = O(n)
 * SC = O(n)
 *
 *
 * ============
 * approach : 2
 * ============
 * using 2 pointers , fast and slow (move by 1 and 2 steps)
 *
 * if at any time , fast == slow : loop is there
 * else if any of them becomes null : no loop
 *
 *
 * ==============
 * TC = O(n)
 * SC = O(1)
 *
 *
 *
 */


public class p3_check_loop {

    public static void main(String[] args) {

        //has loop
        SLL head;
        head = new SLL(1);
        head.next = new SLL(2);
        head.next.next = new SLL(3);
        head.next.next.next = new SLL(4);
        head.next.next.next.next = head.next;

        //no loop
//        SLL head;
//        head = new SLL(1);
//        head.next = new SLL(2);
//        head.next.next = new SLL(3);
//        head.next.next.next = new SLL(4);
//        head.next.next.next.next = new SLL(5);

        boolean answer = p3_check_loop_soln.check(head);

        System.out.println(answer);

    }
}


class p3_check_loop_soln {


    static boolean check(SLL head) {

        if (head == null || head.next == null) {
            return false;
        }

        SLL slow = head;
        SLL fast = head.next;

        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;

    }

}
