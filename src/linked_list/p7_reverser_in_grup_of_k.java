package linked_list;

import models.SLL;

/**
 * leetcode id :
 *
 * reverse a linked list in groups of K
 *
 *
 * ========
 * example
 * ========
 *
 * Input: 1->2->3->4->5->6->7->8->NULL, K = 3
 * Output: 3->2->1->6->5->4->8->7->NULL
 *
 * Input: 1->2->3->4->5->6->7->8->NULL, K = 5
 * Output: 5->4->3->2->1->8->7->6->NULL
 *
 *
 */

/**
 *
 *
 * ============
 * approach : 1
 * ============
 *
 * concept similar to reversing the entire linked list
 *
 * but here we have to check K as well
 *
 * ==============
 * TC = O(n)
 * SC = O(1)
 *
 *
 *
 *
 */

public class p7_reverser_in_grup_of_k {

    public static void main(String[] args) {

        SLL head = new SLL(1);
        head.next = new SLL(2);
        head.next.next = new SLL(3);
        head.next.next.next = new SLL(4);
        head.next.next.next.next = new SLL(5);
        head.next.next.next.next.next = new SLL(6);
        head.next.next.next.next.next.next = new SLL(7);
        head.next.next.next.next.next.next.next = new SLL(8);

        int k = 3;

        head.printList(head);
        head = new p7_reverser_in_grup_of_k_soln().reverse(head, k);
        head.printList(head);
    }
}


class p7_reverser_in_grup_of_k_soln {

    private int K;

    SLL reverse(SLL head, int k) {
        this.K = k;
        return this.helper(head, k);
    }

    private SLL helper(SLL head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        SLL cur = head;
        SLL prv = null;
        SLL nxt = null;

        while (cur != null && k > 0) {
            k--;
            nxt = cur.next;
            cur.next = prv;
            prv = cur;
            cur = nxt;
        }

        head.next = helper(cur, this.K);
        return prv;
    }


}
