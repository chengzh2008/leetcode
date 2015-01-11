package src.main.java;

/**
 * Created by xiaoyazi on 1/10/15.
 * Given a linked list, remove the nth node from the end of
 * list and return its head.
 *
 * For example,
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list
 * becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        while(n > 0) {
            first = first.next;
            n--;
        }
        if (first == null) {
            ListNode newHead = head.next;
            head.next =null;
            return newHead;
        }
        while(first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
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
