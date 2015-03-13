package src.main.java;

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        // check the edge case
        if (head == null || head.next == null || head.next.next == null) return false;
        // slow and fast pointer, the idea behind this:
        // if there is a cycle, the two points will point to the same node somewhere.
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next != null && fast.next.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
