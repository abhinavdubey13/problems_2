package linked_list;

import models.SLL;


/**
 *
 *
 * Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln.
 *
 * Rearrange the nodes in the list so that the new formed list is :
 * L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2
 *
 *
 * use no extra space
 *
 * ========
 * example
 * ========
 *
 * Input:  1 -> 2 -> 3 -> 4
 * Output: 1 -> 4 -> 2 -> 3
 *
 * Input:  1 -> 2 -> 3 -> 4 -> 5
 * Output: 1 -> 5 -> 2 -> 4 -> 3
 *
 *
 */

/**
 *
 *
 * ============
 * approach : 1
 * ============
 * 1) Find the middle point using slow and fat pointer
 * 2) Split the linked list into two halves using found middle point in step 1.
 * 3) Reverse the second half.
 * 4) Do alternate merge of first and second halves.
 *
 *
 * ============
 * TC = O(n)
 * SC = O(1)
 *
 *
 *
 * ============
 * approach : 2
 * ============
 *
 * similar to checking list is palindrome ,
 *
 * append L and then R each time at the end of the list
 *
 *
 * ============
 * TC = O(n)
 * SC = O(1)
 *
 *
 */


public class p9_rearrage_alternate_first_n_last {

    public static void main(String[] args) {

        // //expected : 1 6 2 5 3 4
        SLL head = new SLL(1);
        head.next = new SLL(2);
        head.next.next = new SLL(3);
        head.next.next.next = new SLL(4);
        head.next.next.next.next = new SLL(5);
        head.next.next.next.next.next = new SLL(6);

        //expected : 1 5 2 4 3
//        SLL head = new SLL(1);
//        head.next = new SLL(2);
//        head.next.next = new SLL(3);
//        head.next.next.next = new SLL(4);
//        head.next.next.next.next = new SLL(5);

        head.printList(head);
        head = new p9_rearrage_alternate_first_n_last_soln().rearrage(head);
        head.printList(head);
    }

}


class p9_rearrage_alternate_first_n_last_soln {

    private boolean CONTINUE;
    SLL FINAL_LIST_HEAD;
    SLL FINAL_LIST_CURR;
    SLL LEFT_PTR;

    SLL rearrage(SLL head) {
        if (head == null || head.next == null) {
            return head;
        }

        //initialization of global variables
        this.CONTINUE = true;
        this.FINAL_LIST_HEAD = head;
        this.LEFT_PTR = head.next;
        this.FINAL_LIST_CURR = head;
        this.FINAL_LIST_HEAD.next = null;

        //calling the core method
        helper(this.LEFT_PTR);
        return FINAL_LIST_HEAD;
    }

    private void helper(SLL rightPtr) {

        if (rightPtr == null) {
            return;
        }
        helper(rightPtr.next);

        if (this.CONTINUE && this.LEFT_PTR == rightPtr) {
            this.CONTINUE = false;
            this.FINAL_LIST_CURR.next = rightPtr;
            this.FINAL_LIST_CURR.next.next = null;
            return;
        }

        if (this.CONTINUE && this.LEFT_PTR.next == rightPtr) {
            this.CONTINUE = false;
            this.FINAL_LIST_CURR.next = rightPtr;
            this.FINAL_LIST_CURR.next.next = this.LEFT_PTR;
            this.FINAL_LIST_CURR.next.next.next = null;
            return;
        }


        if (this.CONTINUE) {
            this.FINAL_LIST_CURR.next = rightPtr;
            this.FINAL_LIST_CURR.next.next = this.LEFT_PTR;
            this.FINAL_LIST_CURR = this.LEFT_PTR;
            this.LEFT_PTR = this.LEFT_PTR.next;
            this.FINAL_LIST_CURR.next = null;
        }


    }


}
