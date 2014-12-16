public class InsertionSortList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode current = head;
		ListNode next = current.next;
		while (next != null) {
			if (next.val >= current.val) {
				current = current.next;
			} else {
				if (current == head) {
					current.next = next.next;
					next.next = current;
					head = next;
				} else {
					ListNode find = head;
					if (find.val > next.val) {
						current.next = next.next;
						next.next = find;
						head = next;
					} else {
						while (find.next.val < next.val) {
							find = find.next;
						}
					}
					current.next = next.next;
					next.next = find.next;
					find.next = next;
				}
			}
			next = current.next;
		}
		return head;
	}

	public static void main(String[] args) { 
	}
}
