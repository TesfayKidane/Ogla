package ds.linkedlist;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
    class ListNode {
        int val;

        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode t = head;

        while (t != null) {
            if(t == head) {
                p = new ListNode(t.val);
                p.next = null;
            } else {
                ListNode n = new ListNode(t.val);
                n.next = p;
                p = n;
            }
            t = t.next;
        }

        return p;
    }

    public ListNode reverseListNode2 (ListNode head) {
        // two pointers (previous and current);
        // temp pointer
        ListNode current = head;
        ListNode previous = null;
        ListNode temp = null;
        while(current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }
}
