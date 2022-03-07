package linked_list;


import models.SLL;

/**
 *
 *
 * ============
 * approach : 1
 * ============
 * k'th from last = (n-k+1) from beginning
 * but here we need n , ie. length of the linked-list
 * ==============
 * TC = O(n)
 * SC = O(1)
 *
 *
 * =============
 * approach : 2
 * =============
 *
 * similar to checking list is palindrome
 *
 * using head-first recursion , goto last node
 *
 * start counting when returning back
 *
 * ==============
 * TC = O(n)
 * SC = O(1)
 *
 *

 *
 *
 *
 *
 */
public class p6_kth_node_from_end {

    public static void main(String[] args) {

        SLL head;
        head = new SLL(1);
        head.next = new SLL(2);
        head.next.next = new SLL(3);
        head.next.next.next = new SLL(4);
        head.next.next.next.next = new SLL(5);
        head.next.next.next.next.next = new SLL(6);

        int k = 2; //expected = 5
        // int n = 13; //expected = -1

        new p6_kth_node_from_end_soln_1().print(head, k);
    }

}


class p6_kth_node_from_end_soln_1 {

    private int K;

    void print(SLL head, int k) {
        if (head == null) {
            return;
        }
        this.K = k;
        helper(head);
    }


    private void helper(SLL curr) {
        if (curr == null) {
            return;
        }

        helper(curr.next);
        this.K--;

        if (this.K == 0) {
            System.out.print(curr.val);
        }
    }



}
