package src.main.java;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * Show Tags
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return helper(head);
    }

    public TreeNode helper(ListNode head) {
        TreeNode root;
        // if head is null
        if (head == null) return null;
        // if head is a single element ListNode.
        if (head.next == null) return new TreeNode(head.val);
        // if head contains two ListNodes
        if (head.next.next == null) {
            root = new TreeNode(head.val);
            root.right = new TreeNode(head.next.val);
            return root;
        }
        // three or more listNodes.
        ListNode fast = head;
        ListNode slow = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            if (slow == null) {
                slow = head;
            } else {
                slow = slow.next;
            }
        }
        // slow.next is the middle as the root of the tree node
        ListNode middle = slow.next;
        ListNode right = middle.next;
        // nullify the tail of the left part.
        slow.next = null;
        root = new TreeNode(middle.val);
        root.left = helper(head);
        root.right = helper(right);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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
