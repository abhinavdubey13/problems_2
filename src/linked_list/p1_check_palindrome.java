package linked_list;

import models.SLL;

public class p1_check_palindrome {

    public static void main(String[] args) {
        SLL head;
        head = new SLL(1);
        head.next = new SLL(2);
        head.next.next = new SLL(4);
        head.next.next.next = new SLL(4);
        head.next.next.next.next = new SLL(2);
        head.next.next.next.next.next = new SLL(1);

        System.out.println(new p1_check_palindrome_soln().check(head));
    }
}


class p1_check_palindrome_soln {

    SLL leftPtr;

    boolean check(SLL head) {
        if (head == null || head.next == null) {
            return true;
        }

        leftPtr = head;
        return helper(head);
    }


    boolean helper(SLL rightPtr) {
        if (rightPtr == null) {
            return true;
        }

        boolean prev_res = helper(rightPtr.next);
        boolean toReturn = (prev_res && rightPtr.val == leftPtr.val);
        leftPtr = leftPtr.next;
        return toReturn;
    }
}


