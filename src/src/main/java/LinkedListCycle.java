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
        ListNode slow = head;
        ListNode fast = head;
        while(slow!=null&& fast!=null) {
            slow=slow.next;
            fast=fast.next;
            if(fast!=null) {
                fast=fast.next;
            }
            if (fast == slow) { // deal with the edge case
                break;
            }
        }
        if (fast!=null) return true;
        return false;
    }
}
