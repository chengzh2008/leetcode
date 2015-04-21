package src.main.java;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
/**
 *Definition for singly-linked list.
 *
 */

public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        ListNode firstHead = null;
        ListNode firstTail = firstHead;
        ListNode secondHead = null;
        ListNode secondTail = secondHead;
        ListNode cur = head;
        if (head == null || head.next == null) return head;
        while(cur!= null) {
            append(cur, firstHead, firstTail);
            cur = cur.next;
            if (cur != null) {
                append(cur, secondHead, secondTail);
                cur = cur.next;
            }
        }
        firstHead = sortList(firstHead);
        secondHead = sortList(secondHead);
        return merge(firstHead, secondHead);

    }

    public void append(ListNode node, ListNode head, ListNode tail) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    public ListNode merge(ListNode first, ListNode second) {
        ListNode head = null;
        ListNode cur = head;
        ListNode p1 = first;
        ListNode p2 = second;
        while(p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                if (head == null) {
                    head = p1;
                    cur = head;
                } else {
                    cur.next = p1;
                    cur = cur.next;
                }
                p1 = p1.next;
            } else {
                if (head == null) {
                    head = p2;
                    cur = head;
                } else {
                    cur.next = p2;
                    cur = cur.next;
                }
                p2 = p2.next;
            }
        }
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
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
