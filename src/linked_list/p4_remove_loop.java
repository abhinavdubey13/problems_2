package linked_list;

import java.util.*;
import models.*;

/**
 * leetcode id :
 *
 * Given a linked list, check if the linked list has loop or not.
 *
 * also if loop exist , remove the loop
 *
 *
 * ========
 * example
 * ========
 *
 *
 */

/**
 *
 *
 * ============
 * approach : 1
 * ============
 * maitain a set of addresses of nodes , if while traversing the list , we get repeated address , it has a loop => make the next as null and return
 * if iterator becomes null , no loop found
 *
 * ==============
 * TC = O(n)
 * SC = O(n)
 *
 *
 *
 *
 */

public class p4_remove_loop {
    public static void main(String[] args) {

        //has loop
        SLL head;
        head = new SLL(1);
        head.next = new SLL(2);
        head.next.next = new SLL(3);
        head.next.next.next = new SLL(4);
        head.next.next.next.next = head.next;

        //no loop
        // Node head;
        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = new Node(5);





    }
}


class p4_remove_loop_soln {

    static boolean has_loop(SLL head) {
        Set<SLL> addresses = new HashSet<>();
        SLL curr = head;

        while (curr != null) {
            if (addresses.contains(curr.next)) {
                curr.next = null; //removes loop
                return true;
            }
            addresses.add(curr);
            curr = curr.next;
        }

        return false;
    }

}

