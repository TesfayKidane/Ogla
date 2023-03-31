package ds.linkedlist;

public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode () {}
        public ListNode (int val) {
            this.val = val;
        }
        public ListNode (int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // find the middle and break
    // reverse the second half
    // merge
    public static ListNode reOrder(ListNode head) {
        // find the middle using slow fast pointer.
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headOfSecondPart = reverse(slow.next);
        ListNode headOfFirstPart = head;
        slow.next = null; // break the linked list



        ListNode tempFirstNext = headOfFirstPart.next;
        ListNode tempSecondNext = headOfSecondPart.next;
        while(headOfFirstPart != null
                && headOfSecondPart != null) {
            headOfFirstPart.next = headOfSecondPart;
            headOfSecondPart.next = tempFirstNext;
            headOfFirstPart = headOfFirstPart.next;
            headOfSecondPart = tempSecondNext;
        }

        return slow;
    }
    public static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode tempNext = null;
        while(current != null) {
            tempNext = current.next;
            current.next = previous;
            previous = current;
            current = tempNext;
        }
        return previous;
    }
}
