/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list. Input: (2 -> 4
 * ->3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 */
public class AddTwoNumbers {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode output = addTwoNumbers(l1, l2, 0);
		return output;
		
	}
	
	private static ListNode addTwoNumbers(ListNode l1, ListNode l2, int n) {
		ListNode output = null;
		if (l1 == null && l2 ==null ) {
			output = addOneNumber(null, n);
		}
		if (l1 != null && l2 == null) {
			output = addOneNumber(l1, n);
		}
		if (l1 == null && l2 != null) {
			 output = addOneNumber(l2, n);
		}
		if (l1 != null && l2 != null) {
			int temp = l1.val + l2.val + n;
			int digit = temp%10;
			int remain = temp / 10;
			output = new ListNode(digit);
			output.next = addTwoNumbers(l1.next, l2.next, remain);
		}
		return output;
	}

	private static ListNode addOneNumber(ListNode l, int n) {
		ListNode output = null;
		if (l == null) {
			if (n > 0) output = new ListNode(n);
		}
		if (l != null) {
			int temp = l.val + n;
			int digit = temp%10;
			int remain = temp / 10;
			output = new ListNode(digit);
			output.next = addOneNumber(l.next, remain);
		}
		return output;
	}

	public static void main(String[] args) {
		ListNode l1 = null;
		l1 = new ListNode(0);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);
		
		ListNode l2 = null;
		l2 = new ListNode(0);
//		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);
		
		ListNode l3 = addTwoNumbers(l1, l2);
		ListNode temp = l3;
		while (temp!= null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}

}
