package src.main.java;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 */
public class SortKsortedList {
    public ListNode mergeKLists(List<ListNode> lists) {
        int n = lists.size();
        if (n == 0) return null;
        ListNode first, last;
        while (lists.size() > 1) {
            first = lists.remove(0);
            last = lists.remove(lists.size() - 1);
            lists.add(lists.size() / 2, merge(first, last));
        }
        return lists.get(0);
    }

    public ListNode merge(ListNode first, ListNode second) {
        ListNode head = null;
        ListNode cur = head;
        ListNode p1 = first;
        ListNode p2 = second;
        while (p1 != null && p2 != null) {
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


    public ListNode mergeKListsPQ(List<ListNode> lists) {
        int n = lists.size();
        if (n == 0) return null;
        Queue<ListNode> q = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        ListNode head = new ListNode(0);
        ListNode cur = null;
        for (ListNode ln : lists) {
            q.offer(ln);
        }
        while (!q.isEmpty()) {
            cur = q.poll();
            head.next = cur;
            if (cur.next != null) {
                q.offer(cur.next);
            }
        }
        return head.next;
    }

}



