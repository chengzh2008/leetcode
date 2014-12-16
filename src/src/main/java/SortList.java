

/**
 * @author Zhihong Cheng
 * Sort a linked list in O(n log n) time using constant space complexity.

 */
public class SortList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode sortList(ListNode head) {
		// split head into two half
		if (head != null && head.next != null) {
			head = mergeSort(head);
		}
		return head;
	}

	private ListNode mergeSort(ListNode head) {
		if (head != null && head.next != null) {
			ListNode halfHead = listSplit(head);
			head = mergeSort(head);
			halfHead = mergeSort(halfHead);
			head = merge(head, halfHead);
		}
		return head;
	}
	
	// merge two sorted list into one in list
	private ListNode merge(ListNode head, ListNode halfHead) {
		ListNode output = null;
		if (head == null && halfHead == null) {
			return output = null;
		}
		if (head != null && halfHead == null) {
			return output = head;
		}
		if (head == null && halfHead != null) {
			return output = halfHead;
		}
		if (head !=null && halfHead != null) {
			if (head.val < halfHead.val) {
				output = head;
				head.next = merge(head.next, halfHead);
			} else if (head.val > halfHead.val) {
				output = halfHead;
				halfHead.next = merge(head, halfHead.next);
			} else {
			    output = head;
			    ListNode temp = head.next;
			    head.next = halfHead;
			    halfHead.next = merge(temp, halfHead.next);
			}
				
		}
		
		return output;
	}
	
	// split a list of head into two half, first half will have 0 or 1 more item than second half
	private ListNode listSplit(ListNode head) {
		int count = 1;
		ListNode current = head;
		ListNode firstTail = head;
		while (current.next != null) {
			count++;
			current = current.next;
			if (count % 2 == 1)
				firstTail = firstTail.next;
		}
		ListNode halfHead = firstTail.next;
		firstTail.next = null;
		return halfHead;
	}

}
