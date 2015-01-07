package src.main.java;

/**
 * Created by xiaoyazi on 1/6/15.
 */
public class IntersectionTwoLinkedList {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lengthA = length(headA);
            int lengthB = length(headB);
            while(lengthA > lengthB) {
                lengthA--;
                headA = headA.next;
            }
            while(lengthB > lengthA) {
                lengthB--;
                headB = headB.next;
            }
            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }

        private int length(ListNode head) {
            int out = 0;
            while(head!= null) {
                out++;
                head= head.next;
            }
            return out;
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
