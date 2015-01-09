package src.main.java;

/**
 * Created by xiaoyazi on 1/8/15.
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes
 * of the first two lists.
 *
 * Strategy: quite often, recursive will be used for linked list problem
 *
 *
 */
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode l1next = l1.next;
        ListNode l2next = l2.next;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2next);
            return l2;
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
