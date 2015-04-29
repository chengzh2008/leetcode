package src.main.java;

/**
 * Created by xiaoyazi on 4/28/15.
 */
public class RotateListII {
    public ListNode rotateRight(SortKsortedList.ListNode head, int k) {

        ListNode current = head;
        if (head == null || head.next == null || k == 0) return head;
        int length = 1;
        // get the length of the list
        while(current.next != null) {
            current = current.next;
            length++;
        }
        // make it circular
        current.next = head;
        // move length-k%length step from the current position
        for (int i = 0; i< length-k%length; i++) {
            current = current.next;
        }
        ListNode newHead = current.next;
        current.next = null;
        return newHead;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
