package src.main.java;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?.
 */
public class LinkedListCycleII {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && slow!=null) {
            fast = fast.next;
            slow = slow.next;
            if(fast!=null) {
                fast=fast.next;
            }
            if (fast == slow) break;
        }
        if (fast==null) return null; // nocycle

        // find the cycle start node
        ListNode temp = head;
        while (temp != fast) {
            temp = temp.next;
            fast= fast.next;
        }
        return temp;
    }
}
