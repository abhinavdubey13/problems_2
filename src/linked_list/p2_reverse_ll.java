package linked_list;

import models.SLL;

/**
 *
 * reverse ll
 *
 */


/**
 *
 * iterative soln
 *
 * TC=n
 * SC=1
 *
 */

public class p2_reverse_ll {


    public static void main(String[] args) {
        //5 nodes
        SLL head = new SLL(1);
        head.next = new SLL(2);
        head.next.next = new SLL(3);
        head.next.next.next = new SLL(4);
        //head.next.next.next.next = new SLL(5);

        head.printList(head);
        head = new p2_reverse_ll_soln().reverse(head);
        head.printList(head);

    }


}


class p2_reverse_ll_soln {

    SLL reverse(SLL head) {

        //atmost 1 node
        if (head == null || head.next == null) {
            return head;
        }


        SLL curr = head;
        SLL nxt = null;
        SLL prv = null;

        while (curr != null) {
            nxt = curr.next; //hold next
            curr.next = prv; //reverse curr
            prv = curr; //move prev
            curr = nxt; //move curr
        }

        return prv;
    }

}
