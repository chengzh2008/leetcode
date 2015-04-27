package src.main.java;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p>
 * return 1->4->3->2->5->NULL.
 * <p>
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        if (m == n) return head;
        int start = 1;
        ListNode current = head;
        ListNode pre = null;
        // locating the start node referenced by the current pointer.
        while(start < m ) {
            current = current.next;
            start++;
            if (pre == null) {
                pre = head;
            } else {
                pre = pre.next;
            }
        }
        ListNode temp=null; // temp hold current.next
        ListNode tempNext;
        ListNode mNode = current;
        // reverse the node start from m
        while(start < n) {
            temp = current.next;
            tempNext = temp.next;
            if (start == m) {
                current.next = null;
            }
            temp.next = current;
            current = temp;
            temp = tempNext;
            start++;
        }
        // rejoin
        mNode.next = temp;
        if (pre ==null) {
            head = current;
        } else {
            pre.next = current;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
