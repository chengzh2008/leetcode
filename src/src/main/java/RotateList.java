
/**
 * @author Zhihong Cheng
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
public class RotateList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode rotateRight(ListNode head, int n) {
		if (head != null) {
			int count = 1;
			ListNode tail = head;
			// find the last item in the list and get the number of items of the
			// list
			while (tail.next != null) {
				tail = tail.next;
				count++;
			}
			// make it a circle
			tail.next = head;

			// calculate the number the head need to move
			int count2 = count - n % count;
			while (count2 > 0) {
				head = head.next;
				tail = tail.next;
				count2--;
			}
			// break the circle
			tail.next = null;
		}
		return head;
	}
}
