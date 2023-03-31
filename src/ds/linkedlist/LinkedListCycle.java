package ds.linkedlist;

import java.util.HashSet;

public class LinkedListCycle {

    class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Time complexity = O(n)
    // Space complexity = O(n)
    public boolean hasCycleHashSet(ListNode ln) {
        HashSet<ListNode> visited = new HashSet<>();

        while(ln != null) {
            if(visited.contains(ln)) return true;
            visited.add(ln);
            ln = ln.next;
        }

        return false;
    }

    // Time complexity = O(n)
    // Space complexity = O(1)
    public boolean hasCycleFastSlowPointer(ListNode ln) {
        ListNode fast = ln;
        ListNode slow = ln;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }
}
