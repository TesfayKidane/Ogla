package company.apple;

import java.util.LinkedList;

public class ReverseLinkedList {

    // We have to go to the end of the list
    // Iterate backwards.
    // return the reversed LinkedList
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseLinkedList(ListNode head) {
        ListNode tail  = head;

        while(head.next != null) {
            tail = head.next;
        }

        return tail;
    }

}
