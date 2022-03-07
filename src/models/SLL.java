package models;

public class SLL {

    public int val;
    public SLL next;

    public SLL() {
    }

    public SLL(int val) {
        this.val = val;
        next = null;
    }

    public void printList(SLL head) {
        System.out.println();
        System.out.print("list : ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
