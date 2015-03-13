package src.main.java;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You must do this in-place without altering the nodes' values.
 * <p>
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head) {
        if (head != null && head.next != null) {

            // devide the list into half
            ListNode slow = head;
            ListNode fast = head;
            while (fast!= null && fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode right = slow.next;
            slow.next = null;

            // reverse the right
            right = reverse(right);

            // merge two list together
            ListNode p1 = head;
            ListNode p2 = right;

            while (p2 != null) {
                ListNode temp1 = p1.next;
                ListNode temp2 = p2.next;
                p1.next = p2;
                p2.next = temp1;
                p1 = temp1;
                p2 = temp2;
            }
        }


    }

    // reverse the linkedlist
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = null; // clean up the head next
        return pre;
    }


}
