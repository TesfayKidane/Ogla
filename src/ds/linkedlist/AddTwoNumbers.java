package ds.linkedlist;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        LinkedList<Integer> al1 = new LinkedList<>();
        LinkedList<Integer> al2 = new LinkedList<>();
        while(l1 != null) {
            al1.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            al2.add(l2.val);
            l2 = l2.next;
        }

        int p1 = 0;
        int p2 = 0;
        int carry = 0;
        ListNode sp = new ListNode();
        ListNode ans = sp;
        while(p1 < al1.size()  || p2 < al2.size()) {
            int x1 = p1 < al1.size() ? al1.get(p1) : 0;
            int x2 = p2 < al2.size() ? al2.get(p2) : 0;

            int value = ( x1 + x2 + carry ) % 10;
            carry = (x1 + x2 + carry) / 10;
            p1++;
            p2++;

            ListNode n = new ListNode(value);
            sp.next = n;
            sp = n;
        }

        if(carry != 0) {
            ListNode n = new ListNode(carry);
            sp.next = n;
            sp = n;
        }

        return ans.next;
    }
}
