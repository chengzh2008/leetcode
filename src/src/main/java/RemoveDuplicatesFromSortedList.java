package src.main.java;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        // handle the case if the duplicates are in the front of the list.
        if (current.val == current.next.val) {
            // move the current reference to the last copy of the duplicates, return the recursive call on its next node
            while (current != null && current.next != null && current.val == current.next.val) {
                current.next = current.next.next;
            }
            return deleteDuplicates(current.next);
        } else {
            // set its next reference by call the method recursively, and return the current reference.
            current.next = deleteDuplicates(current.next);
            return current;
        }

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
